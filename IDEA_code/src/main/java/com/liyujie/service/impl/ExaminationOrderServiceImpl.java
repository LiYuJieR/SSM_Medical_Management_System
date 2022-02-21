package com.liyujie.service.impl;

import com.liyujie.dao.ExaminationOrderDao;
import com.liyujie.entity.ExaminationOrder;
import com.liyujie.service.ExaminationOrderService;

import java.util.List;

public class ExaminationOrderServiceImpl implements ExaminationOrderService {
    private ExaminationOrderDao examinationOrderDao;

    public void setExaminationOrderDao(ExaminationOrderDao examinationOrderDao) {
        this.examinationOrderDao = examinationOrderDao;
    }

    @Override
    public ExaminationOrder queryExaminationOrderById(Integer id) {
        return examinationOrderDao.selectExaminationOrderById(id);
    }

    @Override
    public List<ExaminationOrder> queryExaminationOrderByDId(Integer Did) {
        return examinationOrderDao.selectExaminationOrderByDId(Did);
    }

    @Override
    public List<ExaminationOrder> queryExaminationOrderByPId(Integer Pid) {
        return examinationOrderDao.selectExaminationOrderByPId(Pid);
    }

    @Override
    public List<ExaminationOrder> queryExaminationOrderByEId(Integer Eid) {
        return examinationOrderDao.selectExaminationOrderByEId(Eid);
    }

    @Override
    public List<ExaminationOrder> queryExaminationOrderByPIdNotPaid(Integer Pid) {
        return examinationOrderDao.selectExaminationOrderByPIdNotPaid(Pid);
    }

    @Override
    public int addExaminationOrder(Integer Pid, Integer Did, Integer Eid) {
        ExaminationOrder examinationOrder=new ExaminationOrder();
        examinationOrder.setDid(Did);
        examinationOrder.setEid(Eid);
        examinationOrder.setPid(Pid);
        return examinationOrderDao.insertExaminationOrder(examinationOrder);
    }

    @Override
    public int updateExaminationOrderToPaidById(Integer id) {
        return examinationOrderDao.updateExaminationOrderToPaidById(id);
    }
}
