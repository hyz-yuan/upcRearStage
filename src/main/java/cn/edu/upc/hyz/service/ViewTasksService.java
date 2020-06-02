package cn.edu.upc.hyz.service;

import cn.edu.upc.hyz.manage.model.ViewTasks;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface ViewTasksService {
    List<ViewTasks> getTasksList(HttpSession session);
}
