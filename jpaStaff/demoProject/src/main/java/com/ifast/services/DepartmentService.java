package com.ifast.services;

import com.ifast.dto.DepartmentDto;
import com.ifast.entities.DepartmentBean;

import java.util.List;

public interface DepartmentService {

    public void createDepartment(DepartmentBean department);
    public List<DepartmentBean> getDepartments();
    public void deleteDepartments(int id);
    public DepartmentBean getDepartment(int id);
    public List<DepartmentBean> getDepartmetByCompId(int comp_id);
    public List<DepartmentDto> getDepWithCompName();
}
