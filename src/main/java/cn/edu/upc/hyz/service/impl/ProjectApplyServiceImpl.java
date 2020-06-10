package cn.edu.upc.hyz.service.impl;

import cn.edu.upc.hyz.dao.ProjectApplyMapper;
import cn.edu.upc.hyz.model.ProjectApply;
import cn.edu.upc.hyz.service.ProjectApplyService;

import javax.annotation.Resource;
import java.util.List;

public class ProjectApplyServiceImpl implements ProjectApplyService {
    @Resource
    ProjectApplyMapper projectApplyMapper;

    @Override
    public List<ProjectApply> selectAllApplicant() {
        return null;
    }

    @Override
    public List<ProjectApply> selectByApplicant(Integer id) {
        return null;
    }

    @Override
    public int applyProject(ProjectApply apply) {
        return 0;
    }

    @Override
    public int passedApplication(ProjectApply apply) {
        return 0;
    }

    @Override
    public int deleteApplication(ProjectApply apply) {
        return 0;
    }
}
