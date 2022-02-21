package com.liyujie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientUser {
    private Integer id;
    private String name;
    private String password;
    private Gender gender;
    private Integer age;
    private Integer account=0;
    private String phone;
    private String detail;
    private Integer Did;

}
