package cn.edu.upc.hyz.service;

import cn.edu.upc.hyz.manage.model.*;

import java.util.List;

public interface MessageService {
    public  void insertMessage(Message message);
    List<ViewMessageState> getMessageList(ViewMessageState message);
    List<ViewMessageState> getMessageList(int id);
    void updateReader(ViewMessageState message);
    List<Project> getProjectList();
    List<GroupEx> getGroupList();
    List<User> getUserList();
}
