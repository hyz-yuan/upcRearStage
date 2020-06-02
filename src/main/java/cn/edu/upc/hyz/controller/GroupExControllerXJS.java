package cn.edu.upc.hyz.controller;

import cn.edu.upc.manage.common.CommonReturnType;
import cn.edu.upc.manage.model.*;
import cn.edu.upc.hyz.service.GroupExServiceXJS;
import cn.edu.upc.hyz.service.ProjectServiceXJS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(value = "/project", method = {RequestMethod.POST, RequestMethod.GET})
public class GroupExControllerXJS {
    @Autowired
    private GroupExServiceXJS groupExServiceXJS;
    @Autowired
    private ProjectServiceXJS projectServiceXJS;

    @RequestMapping("/addGroup")
    @ResponseBody
    public CommonReturnType addGroupEx(@RequestBody GroupEx groupEx) {
        groupExServiceXJS.insertGroupEx(groupEx);
        return CommonReturnType.create(null);
    }

    @RequestMapping("/changeGroupName")
    @ResponseBody
    public CommonReturnType changeGroupName(@RequestBody GroupEx changeName) {
        groupExServiceXJS.changeGroupEx(changeName);
        List<GroupEx> list = groupExServiceXJS.selectGroupEx();
        return CommonReturnType.create(list);
    }
    @RequestMapping("/getGroupInfo")
    @ResponseBody
    public CommonReturnType getGroupList(@RequestBody GroupEx group) {
        List<GroupEx> list = groupExServiceXJS.getGroup(group.getProjectId());
        return CommonReturnType.create(list);
    }

    @RequestMapping("/deleteGroup")
    @ResponseBody
    public CommonReturnType deleter(@RequestBody  GroupEx group) {
        groupExServiceXJS.deleteGroupEx(group);
        List<GroupEx> list = groupExServiceXJS.getGroup(group.getProjectId());
        return CommonReturnType.create(list,"删除成功");
    }
    @RequestMapping("/deleteGroupUser")
    @ResponseBody
    public CommonReturnType deleteGroup(@RequestBody GroupUser groupUser) {
        groupExServiceXJS.deleteGroupUser(groupUser);
        List<ViewGroupUser> list = projectServiceXJS.getGroupUser(groupUser.getUserId());
        return CommonReturnType.create(list);
    }
    @RequestMapping("/getGroupUsers")
    @ResponseBody
    public CommonReturnType getGroupUsers(@RequestBody ViewGroupUser2 record) {

        List<ViewGroupUser2> list = groupExServiceXJS.getGroupUsers(record);
        return CommonReturnType.create(list);
    }

}
