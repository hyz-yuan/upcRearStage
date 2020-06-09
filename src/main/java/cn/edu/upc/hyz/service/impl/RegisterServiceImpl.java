package cn.edu.upc.hyz.service.impl;

import cn.edu.upc.hyz.dao.UserMapper;
import cn.edu.upc.hyz.model.User;
import cn.edu.upc.hyz.service.RegisterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService {
    @Resource
    private UserMapper userMapper;

    @Override
    public void insertUser(User user) {
        userMapper.insertSelective(user);
    }

    @Override
    public User selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }


}
