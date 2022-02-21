package com.liyujie.dao;

import com.liyujie.entity.PatientUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PatientUserDao {
    PatientUser selectPatientById(Integer id);

    List<PatientUser> selectPatientByDid(Integer Did);

    int insertPatient(PatientUser patientUser);

    int updatePatient(PatientUser patientUser);

    int deletePatientById(Integer id);

    PatientUser selectPatientByPhone(String phone);

    int updatePatientDoctorByDoctorId(@Param("Did") Integer Did,@Param("id") Integer id);
}
