package cn.edu.upc.hyz.controller;

import cn.edu.upc.hyz.manage.common.CommonReturnType;
import cn.edu.upc.hyz.manage.model.User;
import cn.edu.upc.hyz.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@CrossOrigin
@Controller

@RequestMapping(value="/web")
public class RegisterController {
//    @Autowired
//    private LoginService loginService;
    @Autowired
    private RegisterService registerService;
    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public CommonReturnType register(@RequestBody User user){
            user.setPassword(user.getPassword());
            //user.setPassword(MD5Util.md5(user.getPassword()));
            registerService.insertUser(user);
            return CommonReturnType.create("注册成功");

    }
    @ResponseBody
    @RequestMapping(value = "/selectusername",method = RequestMethod.POST)
    public CommonReturnType selectusername(@RequestBody User record){
       // User user = registerService.selectByUsername(record.getUserName());
        if(registerService.selectByUsername(record.getUserName()) != null) {
            return CommonReturnType.create("用户名已存在");
        }
        else{
            return CommonReturnType.create("恭喜您，此用户名可用");
        }
    }



}
