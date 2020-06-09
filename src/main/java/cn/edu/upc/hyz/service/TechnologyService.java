package cn.edu.upc.hyz.service;

import cn.edu.upc.hyz.model.Technology;

import java.util.List;

public interface TechnologyService {

   public List<Technology> selectTechnology();

   public void updateTechnology(Technology upTechnologyParam);
    public void insertTechnology(Technology upTechnologyParam);
   public void deleteFlag(Technology deleteRecord);
}
