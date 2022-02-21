package com.liyujie.service;

import com.liyujie.entity.Department;
import com.liyujie.entity.DoctorGrade;

import java.util.List;

public interface DoctorGradeService {
    List<DoctorGrade> queryAllGrades();
    String queryGradeNameById(Integer id);
}
