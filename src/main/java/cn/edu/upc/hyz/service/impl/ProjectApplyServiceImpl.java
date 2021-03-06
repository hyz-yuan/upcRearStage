package cn.edu.upc.hyz.service.impl;

import cn.edu.upc.hyz.dao.ProjectApplyMapper;
import cn.edu.upc.hyz.model.Project;
import cn.edu.upc.hyz.model.ProjectApply;
import cn.edu.upc.hyz.service.ProjectApplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("ProjectApplyService")
public class ProjectApplyServiceImpl implements ProjectApplyService {
    @Resource
    ProjectApplyMapper projectApplyMapper;

    @Override
    public List<ProjectApply> selectAllApplicant() {
        return projectApplyMapper.selectAllList();
    }

    @Override
    public List<ProjectApply> selectByApplicant(Integer id) {
        return projectApplyMapper.selectAllListByApplicant(id);
    }

    @Override
    public int applyProject(ProjectApply apply) {
        return projectApplyMapper.insertSelective(apply);
    }

    @Override
    public int passedApplication(ProjectApply apply) {
        return projectApplyMapper.deleteFlagByPrimaryKey(apply);
    }

    @Override
    public int deleteApplication(ProjectApply apply) {
        return projectApplyMapper.deleteFlagByPrimaryKey(apply);
    }

    @Override
    public int updateApplication(ProjectApply apply) {
        return projectApplyMapper.updateByPrimaryKeySelective(apply);
    }
}
