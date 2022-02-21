package com.liyujie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorUser {
    private Integer iddoctoruser;
    private String username;
    private String password;
    private String phone;
    private String email;
    private Integer departmentid;
    private Integer gradeid;
    private String detail;

    public void setId(Integer id)
    {
        setIddoctoruser(id);
    }
    public Integer getId()
    {
        return getIddoctoruser();
    }
}
