package cn.edu.upc.hyz.service.impl;


import cn.edu.upc.hyz.dao.ProgressMapper;
import cn.edu.upc.hyz.model.Progress;
import cn.edu.upc.hyz.service.ProgressServiceXJS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("progressServiceXJS")
public class ProgressServiceXJSImpl implements ProgressServiceXJS {

    @Autowired
    private ProgressMapper progressMapper;
    @Autowired
    private ProgressMapper proMapper;
    @Autowired
    private ProgressMapper updateMapper;
    @Autowired
    private ProgressMapper selectMapper;
    @Autowired
    private ProgressMapper deleteMapper;


    @Override
    public List<Progress> selectProgress(Progress projectId) {
        return progressMapper.selectProgress(projectId);
    }

    @Override
    public void insertProgress(Progress progress) {
        proMapper.insertSelective(progress);
    }

    @Override
    public int updateDel(Progress change) {
        return updateMapper.updateByPrimaryKeySelect(change);
    }

    @Override
    public List<Progress> select() {
        return selectMapper.selectByPrimaryKey();
    }

    @Override
    public int updateDelete(Progress delete) {
        return deleteMapper.updateDelete(delete);
    }
}
