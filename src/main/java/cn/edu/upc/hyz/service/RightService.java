package cn.edu.upc.hyz.service;

import cn.edu.upc.manage.model.Rights;

import java.util.List;


public interface RightService {
    public void insertRight(Rights rights);

    public void deleteRight(Rights rights);
    public void updateRight(Rights rights);
    List<Rights>selectAllRights();
}
