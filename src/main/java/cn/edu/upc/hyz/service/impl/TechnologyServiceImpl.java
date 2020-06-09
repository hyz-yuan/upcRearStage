package cn.edu.upc.hyz.service.impl;

import cn.edu.upc.hyz.dao.TechnologyMapper;
import cn.edu.upc.hyz.model.Technology;
import cn.edu.upc.hyz.service.TechnologyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service("technologyService")
public class TechnologyServiceImpl implements TechnologyService {
    @Resource
    TechnologyMapper technologyMapper;
    @Override
    public List<Technology> selectTechnology() {
        return technologyMapper.technologySelect();
    }

    @Override
    public void updateTechnology(Technology technology) {

        technologyMapper.updateByPrimaryKeySelective(technology);
    }

    @Override
    public void insertTechnology(Technology technology) {

        technologyMapper.insertSelective(technology);


    }

    @Override
    public void deleteFlag(Technology deleteRecord) {
       Technology result = technologyMapper.selectByPrimaryKey(deleteRecord.getId());
        if (result!= null){
            deleteRecord.setDelFlag(1);
            technologyMapper.updateByPrimaryKeySelective(deleteRecord);

        }
    }
}
