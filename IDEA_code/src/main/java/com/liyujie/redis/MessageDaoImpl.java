package com.liyujie.redis;

import com.liyujie.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;

public class MessageDaoImpl implements MessageDao {
    @Autowired
    @Qualifier("redisUtil")
    private RedisUtil redisUtil;

    @Override
    public boolean pushMessage(String key, String value) {
        return redisUtil.lSet(key, value);
    }

    @Override
    public List<String> getAllMessage(String key) {
        List<Object> objs = redisUtil.lGet(key, 0, -1);
        List<String> msgs = new ArrayList<>();
        for (Object obj : objs) {
            msgs.add((String) obj);
        }
        return msgs;
    }
}
