package com.liyujie.service;

import com.liyujie.entity.DoctorUser;
import com.liyujie.entity.Registration;

import java.util.List;

public interface DoctorUserService {
    List<DoctorUser> queryAllDoctors();
    DoctorUser queryDoctorById(Integer id);
    int addDoctorUser(DoctorUser user);
    int removeDoctorUserById(Integer id);
    int updateDoctor(DoctorUser doctorUser);
    List<String> queryAllDepartmentName();
    List<String> queryAllGradeName();
    Integer valid(String account, String password);
    void canRegister(DoctorUser doctorUser);
    List<DoctorUser> queryDoctorsByRegistration(List<Registration> registrations);
}
