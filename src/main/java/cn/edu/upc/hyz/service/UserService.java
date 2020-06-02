package cn.edu.upc.hyz.service;

import cn.edu.upc.manage.model.User;

import java.util.List;

public interface UserService {

    User selectUser(int userId);
    void updateUser(User user);
    /**
     * 从user表里查询manager
     */
    List<User> selectManager();
}
