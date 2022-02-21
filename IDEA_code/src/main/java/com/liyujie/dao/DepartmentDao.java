package com.liyujie.dao;

import com.liyujie.entity.Department;

import java.util.List;

public interface DepartmentDao {
    List<Department> selectAllDepartments();
    String selectDepartmentNameById(Integer id);
}
