package com.liyujie.service.impl;

import com.liyujie.dao.DoctorUserDao;
import com.liyujie.entity.DoctorUser;
import com.liyujie.entity.Registration;
import com.liyujie.exception.RegisterRepeatException;
import com.liyujie.exception.UsernameNotFoundException;
import com.liyujie.exception.WrongPasswordException;
import com.liyujie.service.DoctorUserService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class DoctorUserServiceImpl implements DoctorUserService {
    private DoctorUserDao doctorUserDao;

    @Transactional
    public void setDoctorUserDao(DoctorUserDao doctorUserDao) {
        this.doctorUserDao = doctorUserDao;
    }

    @Override
    public List<DoctorUser> queryAllDoctors() {
        return doctorUserDao.selectAllDoctors();
    }

    @Override
    public DoctorUser queryDoctorById(Integer id) {
        return doctorUserDao.selectDoctorById(id);
    }

    @Transactional
    @Override
    public int addDoctorUser(DoctorUser user) {
        try {
            canRegister(user);
            int index=doctorUserDao.insertDoctorUser(user);
            return index;
        }
        catch (Exception e){
            throw new RegisterRepeatException();
        }
    }

    @Transactional
    @Override
    public int removeDoctorUserById(Integer id) {
        return doctorUserDao.deleteDoctorUserById(id);
    }

    @Transactional
    @Override
    public int updateDoctor(DoctorUser doctorUser) {
        return doctorUserDao.updateDoctor(doctorUser);
    }

    @Override
    public List<String> queryAllDepartmentName() {
        List<DoctorUser> doctorUsers = doctorUserDao.selectAllDoctors();
        List<String> departmentNames = new ArrayList<>();
        for (DoctorUser user : doctorUsers) {
            departmentNames.add(doctorUserDao.selectDepartmentNameByDepartmentId(user.getDepartmentid()));
        }
        return departmentNames;
    }

    @Override
    public List<String> queryAllGradeName() {
        List<DoctorUser> doctorUsers = doctorUserDao.selectAllDoctors();
        List<String> gradeNames = new ArrayList<>();
        for (DoctorUser user : doctorUsers) {
            gradeNames.add(doctorUserDao.selectGradeNameByGradeId(user.getGradeid()));
        }
        return gradeNames;
    }

    /**
     * 判断新的医生能否注册成功
     * 电话号或者email重复不可以注册
     *
     * @param doctorUser
     * @return
     */
    @Override
    public void canRegister(DoctorUser doctorUser) {
        if (doctorUser == null) throw new UsernameNotFoundException();
        String phone = doctorUser.getPhone();
        String email = doctorUser.getEmail();
        if (doctorUserDao.selectDoctorByEmail(email) != null || doctorUserDao.selectDoctorByPhone(phone) != null)
            throw new RegisterRepeatException();
    }

    @Override
    public List<DoctorUser> queryDoctorsByRegistration(List<Registration> registrations) {
        List<DoctorUser> list = new ArrayList<>();
        for (Registration registration : registrations) {
            list.add(queryDoctorById(registration.getDid()));
        }
        return list;
    }

    @Override
    public Integer valid(String account, String password) {
        if (account == null)
            throw new UsernameNotFoundException();
        if (password == null)
            throw new WrongPasswordException();
        DoctorUser doctorUser;
        if (account.contains("@"))
            doctorUser = doctorUserDao.selectDoctorByEmail(account);
        else if (account.length() == 8)
            doctorUser = doctorUserDao.selectDoctorById(Integer.parseInt(account));
        else
            doctorUser = doctorUserDao.selectDoctorByPhone(account);
        if (doctorUser == null) throw new UsernameNotFoundException();
        if (!password.equals(doctorUser.getPassword())) throw new WrongPasswordException();
        return doctorUser.getIddoctoruser();
    }
}
