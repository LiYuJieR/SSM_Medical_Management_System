package com.liyujie.service;

import com.liyujie.entity.ExaminationOrder;

import java.util.List;

public interface ExaminationOrderService {
    ExaminationOrder queryExaminationOrderById(Integer id);

    List<ExaminationOrder> queryExaminationOrderByDId(Integer Did);

    List<ExaminationOrder> queryExaminationOrderByPId(Integer Pid);

    List<ExaminationOrder> queryExaminationOrderByEId(Integer Eid);

    List<ExaminationOrder> queryExaminationOrderByPIdNotPaid(Integer Pid);

    int addExaminationOrder(Integer Pid,Integer Did,Integer Eid);

    int updateExaminationOrderToPaidById(Integer id);
}
