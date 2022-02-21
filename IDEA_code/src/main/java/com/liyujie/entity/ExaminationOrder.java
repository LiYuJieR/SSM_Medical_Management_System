package com.liyujie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExaminationOrder {
    private Integer id;
    private Integer Pid;
    private Integer Did;
    private Integer Eid;
    private Boolean isPaid = false;
}
