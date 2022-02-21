package com.liyujie.dao;

import com.liyujie.entity.ExaminationOrder;

import java.util.List;

public interface ExaminationOrderDao {
    ExaminationOrder selectExaminationOrderById(Integer id);

    List<ExaminationOrder> selectExaminationOrderByDId(Integer Did);

    List<ExaminationOrder> selectExaminationOrderByPId(Integer Pid);

    List<ExaminationOrder> selectExaminationOrderByPIdNotPaid(Integer Pid);

    List<ExaminationOrder> selectExaminationOrderByEId(Integer Eid);

    int insertExaminationOrder(ExaminationOrder examinationOrder);

    int updateExaminationOrderToPaidById(Integer id);
}
