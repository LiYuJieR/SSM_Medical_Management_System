package com.liyujie.service;

import com.liyujie.entity.ExaminationOrder;
import com.liyujie.entity.MedicalExamination;

import java.util.List;

public interface MedicalExaminationService {
    List<MedicalExamination> queryMedicalExaminationByDepartment(Integer departmentId);

    MedicalExamination queryMedicalExaminationById(Integer id);

    List<MedicalExamination> queryMedicalExaminationByOrder(List<ExaminationOrder> orders);
}
