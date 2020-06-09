package cn.edu.upc.hyz.service;


import cn.edu.upc.hyz.model.GroupEx;
import cn.edu.upc.hyz.model.GroupUser;
import cn.edu.upc.hyz.model.ViewGroupUser2;

import java.util.List;

public interface GroupExService {
    /**
     * 插入小组内容
     *
     * @param groupEx
     */
    void insertGroupEx(GroupEx groupEx);

    /**
     * 修改小组内容
     *
     * @param changeName
     */
    void changeGroupEx(GroupEx changeName);

    /**
     * 显示小组内容
     *
     * @return
     */
    List<GroupEx> selectGroupEx();
    /**
     * 根据projectId显示小组内容
     *
     * @return projectId
     */
    List<GroupEx> getGroup(Integer projectId);

    /**
     * 根据id值删除小组，实际是为del_flag赋值为id值
     *
     * @param groupUser
     * @return
     */
    int deleteGroupUser(GroupUser groupUser);
    int deleteGroupEx(GroupEx group);
    List<ViewGroupUser2> getGroupUsers(ViewGroupUser2 record);
}
