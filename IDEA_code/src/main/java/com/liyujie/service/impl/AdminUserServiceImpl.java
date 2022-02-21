package com.liyujie.service.impl;

import com.liyujie.dao.AdminUserDao;
import com.liyujie.entity.AdminUser;
import com.liyujie.entity.DoctorUser;
import com.liyujie.exception.UsernameNotFoundException;
import com.liyujie.exception.WrongPasswordException;
import com.liyujie.service.AdminUserService;

import java.util.List;

public class AdminUserServiceImpl implements AdminUserService {
    private AdminUserDao adminUserDao;

    public void setAdminUserDao(AdminUserDao adminUserDao) {
        this.adminUserDao = adminUserDao;
    }

    @Override
    public void validate(AdminUser user) {
        AdminUser user1=adminUserDao.selectUserByName(user.getUsername());
        if(adminUserDao.selectUserByName(user.getUsername())==null)
            throw new UsernameNotFoundException();
        String correctPassword=adminUserDao.selectUserByName(user.getUsername()).getPassword();
        if(!user.getPassword().equals(correctPassword))
            throw new WrongPasswordException();
    }

    @Override
    public int updatePassword(String name, String newPassword) {
        int index=adminUserDao.updateUserPasswordByName(name, newPassword);
        return index;
    }


}
