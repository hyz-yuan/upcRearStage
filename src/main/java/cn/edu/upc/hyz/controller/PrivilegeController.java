package cn.edu.upc.hyz.controller;

import cn.edu.upc.setting.until.SysUser;
import cn.edu.upc.hyz.service.PriManageService;
import cn.edu.upc.hyz.manage.common.CommonReturnType;
import cn.edu.upc.hyz.manage.model.Rights;
import cn.edu.upc.hyz.manage.model.RightsSetLN;
import cn.edu.upc.hyz.manage.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(value="/manage1",method = {RequestMethod.POST,RequestMethod.GET})
public class PrivilegeController {
    @Autowired
    private PriManageService priManageService;

    @RequestMapping("/setRight")
    @ResponseBody
    public CommonReturnType disRight(){
        List<RightsSetLN> p1 = priManageService.selectAllPrivilege();
        return CommonReturnType.create(p1);
    }

    @RequestMapping("/insertNewRight")
    @ResponseBody
    public CommonReturnType insertNewRight(){
        Rights p2=new Rights();
        p2.setDelFlag(0);
        priManageService.insertNewPrivilege(p2);
        List<RightsSetLN> p1 = priManageService.selectAllPrivilege();
        return CommonReturnType.create(p1);
    }

    @RequestMapping("/updateRight")
    @ResponseBody
    public CommonReturnType updateRight(@RequestBody Rights para){
        priManageService.updatePrivilege(para);
        return CommonReturnType.create(null,null,0,"更新成功");
    }

    @RequestMapping("/deleteRight")
    @ResponseBody
    public CommonReturnType deleteRight(@RequestBody Test para){
        Rights p3=priManageService.selectPrivilegeManage(para.getId());
        p3.setDelFlag(1);
        priManageService.updatePrivilege(p3);
        return CommonReturnType.create(null,null,0,"删除成功");
    }

    @RequestMapping("/selectRightByRole")
    @ResponseBody

    public CommonReturnType selectRightByRole(HttpSession session){
        List<RightsSetLN> p1 = priManageService.selectRightByRole(SysUser.getCurrentUserRole(session));
        return CommonReturnType.create(p1);
    }
}
