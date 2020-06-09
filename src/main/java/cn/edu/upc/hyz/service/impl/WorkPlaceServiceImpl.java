package cn.edu.upc.hyz.service.impl;

import cn.edu.upc.hyz.service.WorkPlaceService;
import cn.edu.upc.hyz.dao.WorkPlaceMapper;
import cn.edu.upc.hyz.model.WorkPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author gsl
 * @date 2020/3/31
 */
@Service("workPlace")
public class WorkPlaceServiceImpl implements WorkPlaceService {
    @Autowired
    @Resource
    WorkPlaceMapper workPlaceMapper;

    @Override
    public List<WorkPlace> selectWorkPlace() {
        return workPlaceMapper.selectWorkPlace();
    }
    @Override
    public List<WorkPlace> workPlaceList() {
        return workPlaceMapper.selectWorkPlace();
    }
    @Override
    public void updateWorkPlace(WorkPlace recordUp) {
        recordUp.setOperator("test");
        workPlaceMapper.updateByPrimaryKeySelective(recordUp);
    }

    @Override
    public void insertsWorkPlace(WorkPlace recordIn) {
        recordIn.setOperator("test");
        workPlaceMapper.insertSelective(recordIn);
    }

    @Override
    public void deleteFlag(WorkPlace recordDel) {
        WorkPlace result = workPlaceMapper.selectByPrimaryKey(recordDel.getId());
        if (result!= null){
            recordDel.setDelFlag(1);
            workPlaceMapper.updateByPrimaryKeySelective(recordDel);

        }
    }
}
