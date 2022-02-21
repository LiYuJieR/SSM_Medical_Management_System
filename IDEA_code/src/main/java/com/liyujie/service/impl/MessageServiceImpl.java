package com.liyujie.service.impl;

import com.liyujie.container.MsgContainer;
import com.liyujie.redis.MessageDao;
import com.liyujie.service.MessageService;

import java.util.List;
import java.util.Map;

public class MessageServiceImpl implements MessageService {
    private MessageDao messageDao;

    public void setMessageDao(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Override
    public boolean push(Integer id, String msg) {
        return messageDao.pushMessage(id.toString(), msg);
    }

    @Override
    public List<String> getAll(Integer id) {
        return messageDao.getAllMessage(id.toString());
    }

    @Override
    public boolean setReadNumToAll(Integer id) {
        int MsgNum = getAll(id).size();
        MsgContainer container = MsgContainer.getInstance();
        Map<Integer, Integer> msgMap = container.getMessageMap();
        msgMap.put(id, MsgNum);
        container.setMessageMap(msgMap);
        return true;
    }

    @Override
    public Integer getReadNum(Integer id) {
        MsgContainer container = MsgContainer.getInstance();
        Map<Integer, Integer> msgMap = container.getMessageMap();
        return msgMap.getOrDefault(id, 0);
    }
}
