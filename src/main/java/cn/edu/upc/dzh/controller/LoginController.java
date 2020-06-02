package cn.edu.upc.dzh.controller;

import cn.edu.upc.dzh.service.LoginService;
import cn.edu.upc.dzh.service.MailSenderSrvServices;
import cn.edu.upc.dzh.until.MD5Util;
import cn.edu.upc.dzh.until.SendEmailUtil;
import cn.edu.upc.dzh.until.SysUser;
import cn.edu.upc.dzh.until.exception.BusinessException;
import cn.edu.upc.dzh.until.exception.EmBusinessError;
import cn.edu.upc.ljh.service.UserService;
import cn.edu.upc.manage.common.CommonReturnType;
import cn.edu.upc.manage.model.RightRole;
import cn.edu.upc.manage.model.User;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import cn.edu.upc.ln.service.RolerManageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.zip.ZipEntry;

@CrossOrigin
@Controller
@RequestMapping(value="/web",method = {RequestMethod.POST,RequestMethod.GET})
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private MailSenderSrvServices mailsend;
    @Autowired
    private SendEmailUtil sendEmailUtil;
    @Autowired
    private RolerManageService rolerManageService;

    @RequestMapping("/login")
    @ResponseBody
    public CommonReturnType login(@RequestBody JSONObject user,HttpSession session){
        String loginName=user.getString("loginName");
        String password= user.getString("password");
        //String password=MD5Util.md5(password2);
        System.out.println("1用户名和密码："+loginName+password);
//        Subject subject = SecurityUtils.getSubject();
        System.out.println("2用户名和密码："+loginName+password);
        UsernamePasswordToken token = new UsernamePasswordToken(loginName,password);
        Map<String,Object> returnMsg = new HashMap<String, Object>();
        User user1 = loginService.selectByUsername(loginName);
        if(user1!=null){
            if(user1.getPassword().equals(password)){
                session.setAttribute("user",user1);
                session.setMaxInactiveInterval(30*60);
                returnMsg.put("loginTips","登陆成功");
                System.out.println("返回权限1");
                returnMsg.put("userType",SysUser.getCurrentUserRole(session));
                return CommonReturnType.create(returnMsg);
            }else{
                throw new BusinessException(EmBusinessError.STUDENT_LOGIN_FAIL);
            }

        }else{
            throw new BusinessException(EmBusinessError.STUDENT_NOT_EXIST);
        }


    }



    @RequestMapping("/sessionTest")
    @ResponseBody
    public CommonReturnType SessionTest(){
        Subject subject=SecurityUtils.getSubject();
        Session session=subject.getSession();
        return CommonReturnType.create(session);
    }

    @RequestMapping("/logout")
    @ResponseBody
    public CommonReturnType logout(HttpSession session){
        session.invalidate();
        return CommonReturnType.create("退出成功");
    }

    @RequestMapping("/pleaseLogin")
    @ResponseBody
    public CommonReturnType pleaseLogin(){
        throw new BusinessException(EmBusinessError.PLEASE_LOGIN);
    }

    @RequestMapping("/noAuth")
    @ResponseBody
    public CommonReturnType noAuth(){
        throw new BusinessException(EmBusinessError.NO_PERMISSSION);
    }

    /**
     *
     * sendCode
     * */
    @RequestMapping("/sendCode")
    @ResponseBody
    public CommonReturnType sendCode(@RequestBody JSONObject jsonObject,final HttpServletRequest request){

        String realName=jsonObject.getString("realName");
        String email=jsonObject.getString("email");

        User user=loginService.selectByEmail(email);
        if(user!=null){
            //判断真实姓名正确与否
            if(!user.getRealName().equals(realName))
                return CommonReturnType.create("真实姓名不正确");
            String code2=smsCode();

            String to = email;  //收件人地址
            String subject = "验证码";   //邮件标题
            String content = code2;    //邮件内容
            mailsend.sendEmail(to,subject,content);    //发送邮件

            final HttpSession session = request.getSession();
            session.setAttribute("code",code2);
            return CommonReturnType.create("发送成功");
        }else{
            return CommonReturnType.create("邮箱没有注册");
        }

    }


    /**
     * 匹配验证码并修改密码
     * @param jsonObject
     * @param request
     * @return
     */
    @RequestMapping("/codeMaching")
    @ResponseBody
    public CommonReturnType codeMaching(@RequestBody JSONObject jsonObject, final HttpServletRequest request){
        String email=jsonObject.getString("email");
        String code=jsonObject.getString("code");
        String newPassword= jsonObject.getString("password");
       // String newPassword= MD5Util.md5(jsonObject.getString("password"));
        HttpSession session=request.getSession();
        String rightCode=session.getAttribute("code").toString();
        System.out.println(code+"   "+rightCode);

        if(rightCode.equals(code)){
            loginService.changePasswordByEmail(newPassword,email);
            return CommonReturnType.create("验证成功");
        }else {
            return CommonReturnType.create("验证失败");
        }


    }



    /**
     * 创建验证码
     * @return
     */
    public static String smsCode(){
        //创建一个6位的随机数字
        String ran = new Random().nextInt(1000000)+"";
        if(ran.length()!=6){
            smsCode();
        }
        return ran;
    }
}
