package com.liyujie.redis;

import java.util.List;

public interface MessageDao {
    public boolean pushMessage(String key,String value);

    public List<String> getAllMessage(String key);
}
