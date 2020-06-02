package cn.edu.upc.hyz.service.impl;

import cn.edu.upc.hyz.service.RolerManageService;
import cn.edu.upc.hyz.manage.dao.RightRoleMapper;
import cn.edu.upc.hyz.manage.dao.RoleMapper;
import cn.edu.upc.hyz.manage.dao.ViewRightsRoleMapper;
import cn.edu.upc.hyz.manage.model.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("RolerManageService")
public class RolerManageServiceImpl implements RolerManageService {
    @Resource
    RoleMapper roleMapper;
    @Resource
    ViewRightsRoleMapper viewRightsRoleMapper;
    @Resource
    RightRoleMapper rightRoleMapper;
    public List<ViewRightsRole> selectAllRoler(){
        return viewRightsRoleMapper.selectAllRolesLN();
    }
    public int insertNewRole(Role role){
        roleMapper.insert(role);
        return roleMapper.selectLastInsert();
    }
    public void insertNewRightRole(RightRole rightRole){
        rightRoleMapper.insert(rightRole);
    }
    public void deleteRightRole(long id) {
        rightRoleMapper.deleteByPrimaryKey(id);
    }
    public void delete(long id){
        rightRoleMapper.deleteRightRoleLN(id);
        roleMapper.deleteRoleLN(id);
    }
    public List<RightRole> selectByRoleId(long id){
        return rightRoleMapper.selectByRoleIdLN(id);
    }
    public void updateRoleName(RightRoleInput rightRoleInput){
        roleMapper.updateRoleName(rightRoleInput);
    }
}
