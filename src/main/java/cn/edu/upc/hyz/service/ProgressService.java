package cn.edu.upc.hyz.service;

import cn.edu.upc.hyz.manage.model.Progress;

import java.util.List;

public interface ProgressService {
    List<Progress> selectByProjectId(int id);
    void insert(Progress progress);
    void delete(int id);
    void update(Progress progress);
}
