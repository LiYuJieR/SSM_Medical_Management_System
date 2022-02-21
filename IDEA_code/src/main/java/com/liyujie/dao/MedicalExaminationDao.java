package com.liyujie.dao;

import com.liyujie.entity.MedicalExamination;

import java.util.List;

public interface MedicalExaminationDao {
    List<MedicalExamination> selectMedicalExaminationByDepartment(Integer departmentId);

    MedicalExamination selectMedicalExaminationById(Integer id);
}
