package cn.edu.upc.hyz.controller;

import cn.edu.upc.hyz.common.CommonReturnType;
import cn.edu.upc.hyz.model.Progress;
import cn.edu.upc.hyz.service.ProgressService;
import cn.edu.upc.hyz.service.ProgressServiceXJS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(value="/progress",method = {RequestMethod.POST,RequestMethod.GET})
public class ProgressController {

    @Autowired
    private ProgressService progressService;
    @Autowired
    private ProgressServiceXJS progressService2;

    @RequestMapping("/getProgressList")
    @ResponseBody
    public CommonReturnType getProgressList(@RequestBody Progress progress) {
       // if(progress.getProjectId()==0){progress.setProjectId(1);}
        List<Progress> p=progressService.selectByProjectId(progress.getProjectId());
        return CommonReturnType.create(p);
    }
    @RequestMapping("/addProgressList")
    @ResponseBody
    public CommonReturnType addProjectList(@RequestBody Progress progress) {
        if(progress.getProjectId()==0){progress.setProjectId(1);}
        progressService.insert(progress);
        List<Progress> p=progressService.selectByProjectId(progress.getProjectId());
        return CommonReturnType.create(p);
    }
    @RequestMapping("/deleteProgressList")
    @ResponseBody
    public CommonReturnType deleteProjectList(@RequestBody Progress progress) {
        int projectId=progress.getProjectId();
        progressService.delete(progress.getId());
        List<Progress> p=progressService.selectByProjectId(projectId);
        return CommonReturnType.create(p);
    }
    @RequestMapping("/updateProgressList")
    @ResponseBody
    public CommonReturnType updateProjectList(@RequestBody Progress progress) {
        progressService.update(progress);
        List<Progress> p=progressService.selectByProjectId(progress.getProjectId());
        return CommonReturnType.create(p);
    }
    @RequestMapping("/getProgressList1")
    @ResponseBody
    public CommonReturnType getData(@RequestBody Progress projectId) {
        List<Progress> list = progressService2.selectProgress(projectId);
        return CommonReturnType.create(list);
    }

    @RequestMapping("/addProgress")
    @ResponseBody
    public CommonReturnType addProgress(@RequestBody Progress progress) {
        progressService2.insertProgress(progress);
        return CommonReturnType.create(null);
    }

    @RequestMapping("/updateProgress")
    @ResponseBody
    public CommonReturnType updateProgress(@RequestBody Progress change) {
        progressService2.updateDel(change);
        List<Progress> list = progressService2.select();
        return CommonReturnType.create(list);
    }

    @RequestMapping("/deleteProgress")
    @ResponseBody
    public CommonReturnType deleteProgress(@RequestBody Progress delete) {
        progressService2.updateDelete(delete);
        List<Progress> list = progressService2.select();
        return CommonReturnType.create(list);
    }
}
