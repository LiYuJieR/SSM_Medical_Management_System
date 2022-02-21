package com.liyujie.dao;

import com.liyujie.entity.DoctorUser;

import java.util.List;

public interface DoctorUserDao {
    List<DoctorUser> selectAllDoctors();

    DoctorUser selectDoctorByName(String name);

    DoctorUser selectDoctorByEmail(String email);

    DoctorUser selectDoctorById(Integer id);

    DoctorUser selectDoctorByPhone(String phone);

    int insertDoctorUser(DoctorUser doctorUser);

    int deleteDoctorUserById(Integer id);

    int updateDoctor(DoctorUser doctorUser);

    String selectDepartmentNameByDepartmentId(Integer departmentId);

    String selectGradeNameByGradeId(Integer gradeId);


}
