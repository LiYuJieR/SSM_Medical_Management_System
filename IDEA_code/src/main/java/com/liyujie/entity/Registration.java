package com.liyujie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Registration {
    private Integer id;
    private Integer Did;
    private Integer Pid;
    private Date day;
    private Time beginTime;
    private Time endTime;
    private boolean isRegisted;

}
