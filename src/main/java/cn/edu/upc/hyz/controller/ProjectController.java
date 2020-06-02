package cn.edu.upc.hyz.controller;

import cn.edu.upc.manage.common.CommonReturnType;
import cn.edu.upc.manage.model.Project;
import cn.edu.upc.hyz.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(value="/project",method = {RequestMethod.POST,RequestMethod.GET})
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping("/addProject")
    @ResponseBody
    public CommonReturnType addProject(@RequestBody Project project) {
        projectService.insertProject(project);
        return CommonReturnType.create(null);
    }
    @RequestMapping("/projectList")
    @ResponseBody
    public CommonReturnType projectList() {
        List list=new ArrayList();
        Project p=projectService.selectByPrimaryKey(1);
        for(int i=0;i<20;i++)
        list.add(p);
        return CommonReturnType.create(list);
    }
    @RequestMapping("/getProjectByManagerId")
    @ResponseBody
    public CommonReturnType getProjectList(HttpSession session) {
        List<Project> p=projectService.selectByManager(session);
        return CommonReturnType.create(p);
    }

}
