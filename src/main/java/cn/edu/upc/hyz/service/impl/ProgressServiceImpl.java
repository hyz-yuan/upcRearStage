package cn.edu.upc.hyz.service.impl;

import cn.edu.upc.hyz.dao.ProgressMapper;
import cn.edu.upc.hyz.model.Progress;
import cn.edu.upc.hyz.service.ProgressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("progressServcie")
public class ProgressServiceImpl implements ProgressService {
    @Resource
    private ProgressMapper progressMapper;
    @Override
    public List<Progress> selectByProjectId(int id) {
        return progressMapper.selectByProjectId(id);
    }

    @Override
    public void insert(Progress progress) {
        progressMapper.insertSelective(progress);
    }

    @Override
    public void delete(int id) {
        Progress p=new Progress();
        p.setId(id);
        p.setDelFlag(1);
        progressMapper.updateByPrimaryKeySelective(p);
    }

    @Override
    public void update(Progress progress) {
        progressMapper.updateByPrimaryKeySelective(progress);
    }
}
