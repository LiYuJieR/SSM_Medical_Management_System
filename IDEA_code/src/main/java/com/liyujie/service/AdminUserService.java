package com.liyujie.service;

import com.liyujie.entity.AdminUser;
import com.liyujie.entity.DoctorUser;

import java.util.List;

public interface AdminUserService {
    void validate(AdminUser user);
    int updatePassword(String name,String newPassword);

}
