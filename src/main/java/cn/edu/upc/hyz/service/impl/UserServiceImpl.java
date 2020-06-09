package cn.edu.upc.hyz.service.impl;

import cn.edu.upc.hyz.service.UserService;
import cn.edu.upc.hyz.dao.UserMapper;
import cn.edu.upc.hyz.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userDao;

    @Override
    public User selectUser(int userId) {
        return userDao.selectByPrimaryKey(userId);
    }

    @Override
    public void updateUser(User user){
        userDao.updateByPrimaryKeySelective(user);
    }

    @Override
    public List<User> selectManager() {
        return userDao.selectManagerByRole();
    }
}
