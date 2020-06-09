package cn.edu.upc.hyz.controller;

import cn.edu.upc.hyz.common.CommonReturnType;
import cn.edu.upc.hyz.model.Technology;
import cn.edu.upc.hyz.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(value="/technology",method={RequestMethod.POST, RequestMethod.GET})
public class TechnologyController {
    @Autowired
    public TechnologyService technologyService;
    @RequestMapping("/selectTechnology")

    @ResponseBody


    public CommonReturnType select(){
        List<Technology> list1= technologyService.selectTechnology();
        return  CommonReturnType.create(list1,"查询成功");
    }

    @RequestMapping("/updateTechnology")

    @ResponseBody
    public CommonReturnType update(@RequestBody Technology technology){

        technologyService.updateTechnology(technology);
        List<Technology> list1= technologyService.selectTechnology();
        return  CommonReturnType.create(list1,"更新成功");
    }

    @RequestMapping("/insertNewTechnology")

    @ResponseBody
    public CommonReturnType insert(@RequestBody Technology technology){
        technologyService.insertTechnology(technology);
        List<Technology> list1= technologyService.selectTechnology();
        return  CommonReturnType.create(list1,"插入成功");
    }

    @RequestMapping("/deleteNewTechnology")

    @ResponseBody
    public CommonReturnType deleteFlag(@RequestBody Technology delTechnology){
        technologyService.deleteFlag(delTechnology);
        List<Technology> list1= technologyService.selectTechnology();
        return CommonReturnType.create(list1,"删除成功");
    }


}
