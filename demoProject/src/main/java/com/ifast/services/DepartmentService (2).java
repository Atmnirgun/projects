package com.ifast.services;

import com.ifast.dto.DepartmentDto;
import com.ifast.entities.DepartmentBean;

import java.util.List;

public interface DepartmentService {

    public void addDepartment(DepartmentBean department);
    public List<DepartmentBean> findDepartmentAll();
    public void deleteDepartment(int id);
    public DepartmentBean getDepartment(int id);
    public List<DepartmentBean> findDepartmentByCompId(int comp_id);
    public List<DepartmentDto> findDepWithCompName();
}
