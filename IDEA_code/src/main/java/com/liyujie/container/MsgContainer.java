package com.liyujie.container;

import java.util.HashMap;
import java.util.Map;

/**
 * 这个类用来存储关于已读信息的条数的问题
 */
public class MsgContainer {
    private Map<Integer, Integer> MessageMap = new HashMap<>();

    public Map<Integer, Integer> getMessageMap() {
        return MessageMap;
    }

    public void setMessageMap(Map<Integer, Integer> MessageMap) {
        MessageMap = MessageMap;
    }

    private MsgContainer() {
    }

    private static MsgContainer Instance = new MsgContainer();

    public static MsgContainer getInstance() {
        return Instance;
    }
}
