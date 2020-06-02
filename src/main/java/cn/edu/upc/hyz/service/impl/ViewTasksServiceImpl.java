package cn.edu.upc.hyz.service.impl;

import cn.edu.upc.setting.until.SysUser;
import cn.edu.upc.hyz.manage.dao.ViewTasksMapper;
import cn.edu.upc.hyz.manage.model.ViewTasks;
import cn.edu.upc.hyz.service.ViewTasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class ViewTasksServiceImpl implements ViewTasksService {
    @Autowired
    ViewTasksMapper viewTasksMapper;

    @Override
    public List<ViewTasks> getTasksList(HttpSession session) {
        Integer loginId = SysUser.getCurrentUserId(session);
        List<ViewTasks> list = viewTasksMapper.getTasksList(loginId);
        return list;
    }
}
