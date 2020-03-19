package cn.edu.upc.gsl.service.impl;

import cn.edu.upc.gsl.service.ProjectService2;
import cn.edu.upc.manage.dao.ProjectMapper;
import cn.edu.upc.manage.dao.UserMapper;
import cn.edu.upc.manage.dao.WorkPlaceMapper;
import cn.edu.upc.manage.model.Project;
import cn.edu.upc.manage.model.User;
import cn.edu.upc.manage.model.WorkPlace;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author gsl
 * @date
 */
@Service("projectService2")
public class ProjectServiceImpl implements ProjectService2 {


    @Resource
    ProjectMapper projectMapper;
    @Resource
    WorkPlaceMapper workPlaceMapper;
    @Resource
    UserMapper userMapper;

    /**
     * 根据项目名称返回对应的项目列表
     *
     * @param projectName
     * @return
     */
    @Override
    public List<Project> selectProjectList(String projectName) {

        List<Project> projectList;
        //查询满足条件的所有项目数据
        if (projectName == null || "".equals(projectName)) {
            projectList = projectMapper.getProjectList();
        } else {
            projectList = projectMapper.selectByProjectName(projectName);
        }
        //循环用来进行连表查询并赋值
        for (Project eachProject : projectList) {
            Integer workPlaceId = eachProject.getPlace();
            Integer managerId = eachProject.getManager();

            if (workPlaceId !=null){
                WorkPlace workPlace = workPlaceMapper.selectByPrimaryKey(workPlaceId);
                eachProject.setPlaceName(workPlace.getWorkPlace());
            }
            if (managerId != null) {
                User manager = userMapper.selectByPrimaryKey(managerId);
                eachProject.setManagerName(manager.getRealName());
            }
        }
        return projectList;
    }

}
