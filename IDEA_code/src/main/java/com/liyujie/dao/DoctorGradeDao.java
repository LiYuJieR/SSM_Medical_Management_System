package com.liyujie.dao;

import com.liyujie.entity.Department;
import com.liyujie.entity.DoctorGrade;

import java.util.List;

public interface DoctorGradeDao {
    List<DoctorGrade> selectAllGrades();
    String selectGradeNameById(Integer id);
}
