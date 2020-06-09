package cn.edu.upc.hyz.controller;

import cn.edu.upc.hyz.common.CommonReturnType;
import cn.edu.upc.hyz.model.*;
import cn.edu.upc.hyz.service.GroupExService;
import cn.edu.upc.hyz.service.ProjectServiceXJS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(value = "/project", method = {RequestMethod.POST, RequestMethod.GET})
public class GroupExController {
    @Autowired
    private GroupExService groupExService;
    @Autowired
    private ProjectServiceXJS projectServiceXJS;

    @RequestMapping("/addGroup")
    @ResponseBody
    public CommonReturnType addGroupEx(@RequestBody GroupEx groupEx) {
        groupExService.insertGroupEx(groupEx);
        return CommonReturnType.create(null);
    }

    @RequestMapping("/changeGroupName")
    @ResponseBody
    public CommonReturnType changeGroupName(@RequestBody GroupEx changeName) {
        groupExService.changeGroupEx(changeName);
        List<GroupEx> list = groupExService.selectGroupEx();
        return CommonReturnType.create(list);
    }
    @RequestMapping("/getGroupInfo")
    @ResponseBody
    public CommonReturnType getGroupList(@RequestBody GroupEx group) {
        List<GroupEx> list = groupExService.getGroup(group.getProjectId());
        return CommonReturnType.create(list);
    }

    @RequestMapping("/deleteGroup")
    @ResponseBody
    public CommonReturnType deleter(@RequestBody  GroupEx group) {
        groupExService.deleteGroupEx(group);
        List<GroupEx> list = groupExService.getGroup(group.getProjectId());
        return CommonReturnType.create(list,"删除成功");
    }
    @RequestMapping("/deleteGroupUser")
    @ResponseBody
    public CommonReturnType deleteGroup(@RequestBody GroupUser groupUser) {
        groupExService.deleteGroupUser(groupUser);
        List<ViewGroupUser> list = projectServiceXJS.getGroupUser(groupUser.getUserId());
        return CommonReturnType.create(list);
    }
    @RequestMapping("/getGroupUsers")
    @ResponseBody
    public CommonReturnType getGroupUsers(@RequestBody ViewGroupUser2 record) {

        List<ViewGroupUser2> list = groupExService.getGroupUsers(record);
        return CommonReturnType.create(list);
    }

}
