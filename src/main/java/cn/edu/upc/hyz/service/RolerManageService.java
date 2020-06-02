package cn.edu.upc.hyz.service;

import cn.edu.upc.hyz.manage.model.*;

import java.util.List;

public interface RolerManageService {
    public List<ViewRightsRole> selectAllRoler();
    public int insertNewRole(Role role);
    public void insertNewRightRole(RightRole rightRole);
    public void deleteRightRole(long id);
    public void delete(long id);
    public List<RightRole> selectByRoleId(long id);
    public void updateRoleName(RightRoleInput rightRoleInput);
}
