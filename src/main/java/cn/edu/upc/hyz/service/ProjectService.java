package cn.edu.upc.hyz.service;

import cn.edu.upc.hyz.model.Project;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface ProjectService {
    public void insertProject(Project project);
    public List<Project> selectByManager(HttpSession session);
    public Project selectByPrimaryKey(int id);
}
