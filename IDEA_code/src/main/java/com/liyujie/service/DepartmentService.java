package com.liyujie.service;

import com.liyujie.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> queryAllDepartments();
    String queryDepartmentNameById(Integer id);
}
