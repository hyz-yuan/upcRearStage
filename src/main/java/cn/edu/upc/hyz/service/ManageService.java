package cn.edu.upc.hyz.service;

import cn.edu.upc.hyz.model.Manage;

import java.util.List;


public interface ManageService {
    public List<Manage > selectTechnology();
    public void updateTechnology(Manage record);
    public void insertTechnology(Manage record);
    public void deleteFlag(Manage manage);

}
