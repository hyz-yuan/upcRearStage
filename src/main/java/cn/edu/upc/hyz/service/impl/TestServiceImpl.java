package cn.edu.upc.hyz.service.impl;

import cn.edu.upc.hyz.dao.MessageMapper;
import cn.edu.upc.hyz.dao.ViewMessageStateMapper;
import cn.edu.upc.hyz.model.Message;
import cn.edu.upc.hyz.model.ViewMessageState;
import cn.edu.upc.hyz.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    ViewMessageStateMapper viewMessageStateMapper;
    @Autowired
    MessageMapper messageMapper;

    @Override
    public List<ViewMessageState> getMessageList(Integer id) {
        List<ViewMessageState> list = viewMessageStateMapper.getMessageList(id);
        return list;
    }

    @Override
    public void updateReader(int id, int uid) {
        Message result = messageMapper.selectByPrimaryKey(id);
        if (result != null){
            Message message = new Message();
            message.setId(id);
            message.setReader(result.getReader()+uid+',');
            messageMapper.updateByPrimaryKeySelective(message);
        }
    }
}
