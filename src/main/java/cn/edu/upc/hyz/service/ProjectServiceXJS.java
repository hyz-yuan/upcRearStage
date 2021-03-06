package cn.edu.upc.hyz.service;


import cn.edu.upc.hyz.model.ViewGroupUser;
import cn.edu.upc.hyz.model.ViewGroupUser2;

import java.util.List;

public interface ProjectServiceXJS {
    /**
     * 获取项目列表
     *
     * @return
     */
    List<String> getProjectName();
    /**
     * 人员设定
     *
     * @return
     */
    List<ViewGroupUser> getGroupUser(Integer projectId);
    /**
     * 人员设定2
     *
     * @return
     */
    List<ViewGroupUser2> getGroupPerson(Integer projectId);
}
