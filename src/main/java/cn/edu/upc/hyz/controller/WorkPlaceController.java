package cn.edu.upc.hyz.controller;

import cn.edu.upc.hyz.manage.common.CommonReturnType;
import cn.edu.upc.hyz.manage.model.WorkPlace;
import cn.edu.upc.hyz.service.WorkPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(value="/workPlace",method={RequestMethod.POST, RequestMethod.GET})
public class WorkPlaceController {
    @Autowired
    public WorkPlaceService workPlaceService;

    @RequestMapping("/selectWorkPlace")
    @ResponseBody
    public CommonReturnType select(){

        List<WorkPlace> list1= workPlaceService.selectWorkPlace();

        return  CommonReturnType.create(list1,"查询成功");
    }

    @RequestMapping("/updateWorkPlace")

    @ResponseBody
    public CommonReturnType update(@RequestBody WorkPlace recordUp){

        workPlaceService.updateWorkPlace(recordUp);

        return  CommonReturnType.create(null);
    }

    @RequestMapping("/insertWorkPlace")

    @ResponseBody
    public CommonReturnType insert(@RequestBody WorkPlace recordIn){
        workPlaceService.insertsWorkPlace(recordIn);
        List<WorkPlace> list1= workPlaceService.selectWorkPlace();
        String msg;
        return  CommonReturnType.create(list1,"null");
    }

    @RequestMapping("/deleteWorkPlace")

    @ResponseBody
    public CommonReturnType deleteFlag(@RequestBody WorkPlace recordDel){
        workPlaceService.deleteFlag(recordDel);
        return  CommonReturnType.create("null");
    }
    @RequestMapping("/list")
    @ResponseBody
    public CommonReturnType workPlaceList(){
        List<WorkPlace> workPlaceList = workPlaceService.workPlaceList();
        return CommonReturnType.create(workPlaceList,"成功返回所有地点");
    }
}
