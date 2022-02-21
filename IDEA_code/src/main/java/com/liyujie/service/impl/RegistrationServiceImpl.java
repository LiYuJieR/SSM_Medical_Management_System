package com.liyujie.service.impl;

import com.liyujie.dao.RegistrationDao;
import com.liyujie.entity.Registration;
import com.liyujie.service.RegistrationService;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class RegistrationServiceImpl implements RegistrationService {
    private RegistrationDao registrationDao;

    public void setRegistrationDao(RegistrationDao registrationDao) {
        this.registrationDao = registrationDao;
    }
    @Transactional
    @Override
    public int addRegistration(Integer Did,String day, String beginTime, String endTime) {
        day= day.replaceAll("/","-");
        beginTime=beginTime+":00";
        endTime=endTime+":00";
        Date d=Date.valueOf(day);
        Time t1=Time.valueOf(beginTime);
        Time t2=Time.valueOf(endTime);
        Registration registration=new Registration();
        registration.setDid(Did);
        registration.setDay(d);
        registration.setBeginTime(t1);
        registration.setEndTime(t2);
        return registrationDao.insertRegistration(registration);
    }

    @Override
    public Registration queryRegistrarionById(Integer id) {
        return registrationDao.selectRegistrationById(id);
    }

    @Override
    public List<Registration> queryRegistrationByDid(Integer Did) {
        return registrationDao.selectRegistrationByDid(Did);
    }

    @Override
    public List<Registration> queryRegistrationByPid(Integer Pid) {
        return registrationDao.selectRegistrationByPid(Pid);
    }
    @Transactional
    @Override
    public int removePatientRegis(Integer id) {
        return registrationDao.updateRegistrationPid(id,null,false);
    }
    @Transactional
    @Override
    public int setPatientRegis(Integer id, Integer Pid) {
        return registrationDao.updateRegistrationPid(id,Pid,true);
    }
    @Transactional
    @Override
    public int deleteRegistrationById(Integer id) {
        return registrationDao.deleteRegistrationById(id);
    }

    @Override
    public List<Registration> queryRegistrationNotRegistedByDepartmentId(Integer departmentid) {
        if(departmentid==0)
            return registrationDao.selectAllRegistrationNotRegisted();
        else
            return registrationDao.selectRegistrationNotRegistedByDepartmentId(departmentid);
    }
}
