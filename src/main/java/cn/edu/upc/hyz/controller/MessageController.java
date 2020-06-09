package cn.edu.upc.hyz.controller;

import cn.edu.upc.hyz.common.CommonReturnType;
import cn.edu.upc.hyz.model.Message;
import cn.edu.upc.hyz.model.User;
import cn.edu.upc.hyz.model.ViewMessageState;
import cn.edu.upc.hyz.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping(value="/message",method={RequestMethod.POST, RequestMethod.GET})

public class MessageController {
    @Autowired
    private MessageService messageService;
    //发送信息模块
    @RequestMapping("/insertNewMessage")
    @ResponseBody
    public CommonReturnType insertNewMessage(@RequestBody Message message){
        messageService.insertMessage(message);
        return CommonReturnType.create(null);
    }
    //获取收到的信息模块
    @RequestMapping("/getList")
    @ResponseBody
    public CommonReturnType getList(@RequestBody ViewMessageState message, HttpSession session){
        User user=(User) session.getAttribute("user");
        message.setUserId(user.getId());
        return CommonReturnType.create(messageService.getMessageList(message));
    }
    //更新阅读转态
    @RequestMapping("/updateReader")
    @ResponseBody
    public CommonReturnType updateReader(@RequestBody ViewMessageState message, HttpSession session){
        User user=(User) session.getAttribute("user");
        message.setUserId(user.getId());
        messageService.updateReader(message);
        return CommonReturnType.create(null);
    }
    //为发送信息提供名单（项目，小组，人员）
    @RequestMapping("/test")
    @ResponseBody
    public CommonReturnType test(){
        Map<String,Object> list = new LinkedHashMap<String,Object>();
        list.put("technology",messageService.getProjectList());
        list.put("group",messageService.getGroupList());
        list.put("user",messageService.getUserList());
        return CommonReturnType.create(list);
    }

    @RequestMapping("/test1")
    @ResponseBody
    public CommonReturnType test1(@RequestBody Map<String, Integer> id){
        System.out.println(id.get("id"));
        return CommonReturnType.create(messageService.getMessageList(id.get("id")));
    }
}
