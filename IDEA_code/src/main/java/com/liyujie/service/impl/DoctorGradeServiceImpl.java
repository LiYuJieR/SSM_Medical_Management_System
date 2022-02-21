package com.liyujie.service.impl;

import com.liyujie.dao.DoctorGradeDao;
import com.liyujie.entity.Department;
import com.liyujie.entity.DoctorGrade;
import com.liyujie.service.DoctorGradeService;

import java.util.List;

public class DoctorGradeServiceImpl implements DoctorGradeService {
   private DoctorGradeDao doctorGradeDao;

    public void setDoctorGradeDao(DoctorGradeDao doctorGradeDao) {
        this.doctorGradeDao = doctorGradeDao;
    }

    @Override
    public List<DoctorGrade> queryAllGrades() {
        return doctorGradeDao.selectAllGrades();
    }

    @Override
    public String queryGradeNameById(Integer id) {
        return doctorGradeDao.selectGradeNameById(id);
    }
}
