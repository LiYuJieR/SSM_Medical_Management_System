package com.liyujie.service;

import com.liyujie.entity.Registration;

import java.util.List;

public interface RegistrationService {
    int addRegistration(Integer Did,String day, String beginTime, String endTime);

    Registration queryRegistrarionById(Integer id);

    List<Registration> queryRegistrationByDid(Integer Did);

    List<Registration> queryRegistrationByPid(Integer Pid);

    int removePatientRegis(Integer id);

    int setPatientRegis(Integer id,Integer Pid);

    int deleteRegistrationById(Integer id);

    List<Registration> queryRegistrationNotRegistedByDepartmentId(Integer departmentid);
}
