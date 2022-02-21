package com.liyujie.service.impl;

import com.liyujie.dao.MedicalExaminationDao;
import com.liyujie.entity.ExaminationOrder;
import com.liyujie.entity.MedicalExamination;
import com.liyujie.service.MedicalExaminationService;

import java.util.ArrayList;
import java.util.List;

public class MedicalExaminationServiceImpl implements MedicalExaminationService {
    private MedicalExaminationDao medicalExaminationDao;

    public void setMedicalExaminationDao(MedicalExaminationDao medicalExaminationDao) {
        this.medicalExaminationDao = medicalExaminationDao;
    }

    @Override
    public List<MedicalExamination> queryMedicalExaminationByDepartment(Integer departmentId) {
        return medicalExaminationDao.selectMedicalExaminationByDepartment(departmentId);
    }

    @Override
    public MedicalExamination queryMedicalExaminationById(Integer id) {
        return medicalExaminationDao.selectMedicalExaminationById(id);
    }

    @Override
    public List<MedicalExamination> queryMedicalExaminationByOrder(List<ExaminationOrder> orders) {
        List<MedicalExamination> examinations=new ArrayList<>();
        for(ExaminationOrder order:orders){
            examinations.add(medicalExaminationDao.selectMedicalExaminationById(order.getEid()));
        }
        return examinations;
    }
}
