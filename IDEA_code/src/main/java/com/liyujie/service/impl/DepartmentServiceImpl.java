package com.liyujie.service.impl;

import com.liyujie.dao.DepartmentDao;
import com.liyujie.entity.Department;
import com.liyujie.service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDao departmentDao;

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public List<Department> queryAllDepartments() {
        return departmentDao.selectAllDepartments();
    }

    @Override
    public String queryDepartmentNameById(Integer id) {
        return departmentDao.selectDepartmentNameById(id);
    }
}
