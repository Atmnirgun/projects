package com.ifast.services;

import com.ifast.dao.DepartmentDao;
import com.ifast.entities.DepartmentBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public void createDepartment(DepartmentBean department) {
        departmentDao.save(department);
    }

    @Override
    public List<DepartmentBean> getDepartments() {
        return (List<DepartmentBean>) departmentDao.findAll();
    }

    @Override
    public void deleteDepartments(int id) {
        departmentDao.deleteById(id);
    }

    @Override
    public DepartmentBean getDepartment(int id) {
        return departmentDao.findById(id).get();
    }

    @Override
    public List<DepartmentBean> getDepartmetByCompId(int comp_id) {
        return departmentDao.findByComp_id(comp_id);
    }
}
