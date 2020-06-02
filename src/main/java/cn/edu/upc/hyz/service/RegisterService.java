package cn.edu.upc.hyz.service;

import cn.edu.upc.hyz.manage.model.User;
//import cn.edu.upc.yxy.manage.model.User;

public interface RegisterService {
    public void insertUser(User user);
    public User selectByUsername(String username);

}
