package cn.edu.upc.hyz.service.impl;


import cn.edu.upc.hyz.dao.GroupExMapper;
import cn.edu.upc.hyz.dao.GroupUserMapper;
import cn.edu.upc.hyz.model.GroupEx;
import cn.edu.upc.hyz.model.GroupUser;
import cn.edu.upc.hyz.model.ViewGroupUser2;
import cn.edu.upc.hyz.service.GroupExService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("groupExService5")
public class GroupExServiceImpl implements GroupExService {
    @Autowired
    private GroupExMapper GroupExmapper;
    @Autowired
    private GroupUserMapper GroupUsermapper;
    @Autowired
    cn.edu.upc.hyz.dao.ViewGroupUser2Mapper ViewGroupUser2Mapper;
    @Override
    public void insertGroupEx(GroupEx groupEx) {
        GroupExmapper.insertSelective(groupEx);
    }

    @Override
    public void changeGroupEx(GroupEx changeName) {
        GroupExmapper.updateByPrimaryKeySelect(changeName);
    }

    @Override
    public List<GroupEx> selectGroupEx() {
        return GroupExmapper.selectByPrimaryKey();
    }
    @Override
    public List<GroupEx> getGroup(Integer projectId) {
        return GroupExmapper.getGroup(projectId);
    }

    @Override
    public int deleteGroupEx(GroupEx group) {
        group.setDelFlag(group.getId());
        return GroupExmapper.updateDel(group);
    }
    @Override
    public int deleteGroupUser(GroupUser groupUser) {
        groupUser.setDelFlag(groupUser.getId());
        Date date = new Date();
        groupUser.setOperator("");
        groupUser.setOperatorIp("");
        groupUser.setOperatorTime(date);
        return GroupUsermapper.groupDel(groupUser);
    }
    public  List<ViewGroupUser2> getGroupUsers(ViewGroupUser2 record){
        return ViewGroupUser2Mapper.getGroupUsers(record);
    }

}
