package com.liyujie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalExamination {
    private Integer id;
    private String name;
    private Integer departmentid;
    private Float cost;
}
