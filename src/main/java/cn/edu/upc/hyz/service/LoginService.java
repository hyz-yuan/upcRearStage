package cn.edu.upc.hyz.service;

import cn.edu.upc.hyz.model.User;

public interface LoginService {
    public User selectByUsername(String userName);
    public void changePasswordByEmail(String newPassword,String email);
    public User selectByEmail(String email);
}
