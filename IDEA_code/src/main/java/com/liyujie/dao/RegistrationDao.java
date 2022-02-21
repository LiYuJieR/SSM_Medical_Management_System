package com.liyujie.dao;

import com.liyujie.entity.Registration;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RegistrationDao {
    int insertRegistration(Registration registration);

    List<Registration> selectRegistrationByDid(Integer Did);

    List<Registration> selectRegistrationByPid(Integer Pid);

    int updateRegistrationPid(@Param("id")Integer id,@Param("Pid") Integer Pid,@Param("isRegist") boolean isRegist);

    int deleteRegistrationById(Integer id);

    List<Registration> selectAllRegistrationNotRegisted();

    List<Registration> selectRegistrationNotRegistedByDepartmentId(Integer departmentid);

    Registration selectRegistrationById(Integer id);
}
