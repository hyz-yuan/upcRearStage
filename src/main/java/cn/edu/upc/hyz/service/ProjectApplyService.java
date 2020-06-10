package cn.edu.upc.hyz.service;

import cn.edu.upc.hyz.model.ProjectApply;

import java.util.List;

public interface ProjectApplyService {
    /*获取申请列表*/
    List<ProjectApply> selectAllApplicant();
    /*通过申请者获取申请列表*/
    List<ProjectApply> selectByApplicant(Integer id);
    /*申请项目*/
    int applyProject(ProjectApply apply);
    /*申请通过*/
    int passedApplication(ProjectApply apply);
    /*删除申请*/
    int deleteApplication(ProjectApply apply);
    /*修改申请*/
    int updateApplication(ProjectApply apply);
}
