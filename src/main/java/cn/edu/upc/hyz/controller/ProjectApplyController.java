package cn.edu.upc.hyz.controller;

import cn.edu.upc.hyz.common.CommonReturnType;
import cn.edu.upc.hyz.model.Progress;
import cn.edu.upc.hyz.model.ProjectApply;
import cn.edu.upc.hyz.model.User;
import cn.edu.upc.hyz.service.ProjectApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(value="/projectApply",method = {RequestMethod.POST,RequestMethod.GET})
public class ProjectApplyController {
    @Autowired
    ProjectApplyService projectApplyService;

    /*获取用户申请列表*/
    @RequestMapping("/userList")
    @ResponseBody
    public CommonReturnType userList(HttpSession session) {
        User user=(User)session.getAttribute("user");
        List<ProjectApply> list = projectApplyService.selectByApplicant(user.getId());
        return CommonReturnType.create(list);
    }
    /*获取所有申请列表*/
    @RequestMapping("/allList")
    @ResponseBody
    public CommonReturnType allList() {
        List<ProjectApply> list = projectApplyService.selectAllApplicant();
        return CommonReturnType.create(list);
    }

}
