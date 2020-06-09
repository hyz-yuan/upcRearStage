package cn.edu.upc.hyz.controller;

import cn.edu.upc.hyz.common.CommonReturnType;
import cn.edu.upc.hyz.model.Project;
import cn.edu.upc.hyz.model.ViewGroupUser;
import cn.edu.upc.hyz.model.ViewGroupUser2;
import cn.edu.upc.hyz.service.ProjectService;
import cn.edu.upc.hyz.service.ProjectServiceXJS;
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
    @Autowired
    private ProjectServiceXJS projectServiceXJS;

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
    @RequestMapping("/getProjectList")
    @ResponseBody
    public CommonReturnType getProjectList() {
        List<String> list = projectServiceXJS.getProjectName();
        return CommonReturnType.create(list);
    }
    @RequestMapping("/getGroupList")
    @ResponseBody
    public CommonReturnType getGroupList(@RequestBody ViewGroupUser group) {
        List<ViewGroupUser> list = projectServiceXJS.getGroupUser(group.getProjectId());
        return CommonReturnType.create(list);
    }
    @RequestMapping("/getGroupPerson")
    @ResponseBody
    public CommonReturnType getGroupPerson(@RequestBody ViewGroupUser2 group) {
        List<ViewGroupUser2> list = projectServiceXJS.getGroupPerson(group.getProjectId());
        return CommonReturnType.create(list);
    }

}