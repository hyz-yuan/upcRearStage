package cn.edu.upc.hyz.service;

import cn.edu.upc.manage.model.WorkPlace;

import java.util.List;

/**
 * @author gsl
 * @date 2020/3/31
 */
public interface WorkPlaceService {

    /**
     * 获取全部项目地址
     * @return
     */
    public List<WorkPlace> workPlaceList();
    public List<WorkPlace> selectWorkPlace();
    public void updateWorkPlace(WorkPlace recordUp);
    public void insertsWorkPlace(WorkPlace recordIn);
    public void deleteFlag(WorkPlace recordDel);
}
