package cn.edu.upc.hyz.dao;

import cn.edu.upc.hyz.model.ProjectApply;

import java.util.List;

public interface ProjectApplyMapper {

    int deleteByPrimaryKey(Integer id);
    int insert(ProjectApply record);
    int insertSelective(ProjectApply record);
    ProjectApply selectByPrimaryKey(Integer id);
    List<ProjectApply> selectAllList();
    List<ProjectApply> selectAllListByApplicant(Integer id);
    int updateByPrimaryKeySelective(ProjectApply record);
    int updateByPrimaryKey(ProjectApply record);
    int deleteFlagByPrimaryKey(ProjectApply record);
}