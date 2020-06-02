package cn.edu.upc.hyz.service.impl;

import cn.edu.upc.hyz.service.EmployeeManageService;

import cn.edu.upc.hyz.manage.dao.UserMapper;
import cn.edu.upc.hyz.manage.model.EmployeeSelect;
import cn.edu.upc.hyz.manage.model.EmployeeSelectInput;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("EmployeeManageService")
public class EmployeeManageServiceImpl implements EmployeeManageService {
    @Resource
    UserMapper userMapper;
    public List<EmployeeSelect> selectAllEmployee(){
        return userMapper.selectAll();
    }
    public List<EmployeeSelect> selectEmployee(EmployeeSelectInput employeeSelectInput) { return userMapper.selectByName(employeeSelectInput);}
    public void changePassWord(String password,String id){ userMapper.changePassword(password,id); }
}
