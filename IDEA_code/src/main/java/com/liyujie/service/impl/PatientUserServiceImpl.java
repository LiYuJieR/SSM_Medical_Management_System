package com.liyujie.service.impl;

import com.liyujie.dao.PatientUserDao;
import com.liyujie.entity.PatientUser;
import com.liyujie.entity.Registration;
import com.liyujie.exception.PatientOccupiedException;
import com.liyujie.exception.RegisterRepeatException;
import com.liyujie.exception.UsernameNotFoundException;
import com.liyujie.exception.WrongPasswordException;
import com.liyujie.service.PatientUserService;

import java.util.List;

public class PatientUserServiceImpl implements PatientUserService {
    private PatientUserDao patientUserDao;

    public void setPatientUserDao(PatientUserDao patientUserDao) {
        this.patientUserDao = patientUserDao;
    }

    @Override
    public PatientUser queryPatientById(Integer id) {
        return patientUserDao.selectPatientById(id);
    }

    @Override
    public List<PatientUser> queryPatientByDid(Integer Did) {

        return patientUserDao.selectPatientByDid(Did);
    }

    @Override
    public int addPatient(PatientUser patientUser) {
        if(patientUser==null) throw new UsernameNotFoundException();
        if(patientUserDao.selectPatientByPhone(patientUser.getPhone())!=null)
            throw new RegisterRepeatException();
        return patientUserDao.insertPatient(patientUser);
    }

    @Override
    public int updatePatient(PatientUser patientUser) {
        return patientUserDao.updatePatient(patientUser);
    }

    @Override
    public int removePatientById(Integer id) {
        return patientUserDao.deletePatientById(id);
    }

    @Override
    public int valid(String account, String password) {
        if(account==null)
            throw new UsernameNotFoundException();
        if(password==null)
            throw new WrongPasswordException();
        PatientUser patientUser=patientUserDao.selectPatientByPhone(account);
        if(patientUser==null) throw new UsernameNotFoundException();
        if(!password.equals(patientUser.getPassword())) throw new WrongPasswordException();
        return patientUser.getId();
    }

    @Override
    public int updatePatientDoctorByDoctorId(Integer Did, Integer id) {
        PatientUser patientUser=patientUserDao.selectPatientById(id);
        if(patientUser.getDid()!=null) throw new PatientOccupiedException();
        return patientUserDao.updatePatientDoctorByDoctorId(Did,id);
    }


}
