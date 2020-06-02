package cn.edu.upc.hyz.service;

import cn.edu.upc.hyz.manage.model.ViewMessageState;

import java.util.List;

public interface TestService {
    List<ViewMessageState> getMessageList(Integer id);
    void updateReader(int id, int uid);
}
