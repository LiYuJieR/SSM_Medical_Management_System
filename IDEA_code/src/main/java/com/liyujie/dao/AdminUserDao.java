package com.liyujie.dao;

import com.liyujie.entity.AdminUser;
import com.liyujie.entity.DoctorUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminUserDao {
    AdminUser selectUserByName(@Param("name") String name);
    //有两个参数必须要用@Param注解
    int updateUserPasswordByName(@Param("name")String name,@Param("newPassword")String newPassword);


}
