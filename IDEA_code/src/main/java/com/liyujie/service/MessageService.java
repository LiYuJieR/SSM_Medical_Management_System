package com.liyujie.service;

import javax.swing.*;
import java.util.List;

public interface MessageService {
    public boolean push(Integer id,String msg);

    public List<String> getAll(Integer id);

    public boolean setReadNumToAll(Integer id);

    public Integer getReadNum(Integer id);
}
