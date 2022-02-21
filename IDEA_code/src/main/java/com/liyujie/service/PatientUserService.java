package com.liyujie.service;

import com.liyujie.entity.PatientUser;
import com.liyujie.entity.Registration;

import java.util.List;

public interface PatientUserService {
    PatientUser queryPatientById(Integer id);

    List<PatientUser> queryPatientByDid(Integer Did);

    int addPatient(PatientUser patientUser);

    int updatePatient(PatientUser patientUser);

    int removePatientById(Integer id);

    int valid(String account,String password);

    int updatePatientDoctorByDoctorId(Integer Did,Integer id);
}
