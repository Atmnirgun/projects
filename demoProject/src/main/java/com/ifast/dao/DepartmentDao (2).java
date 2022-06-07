package com.ifast.dao;

import com.ifast.dto.DepartmentDto;
import com.ifast.entities.DepartmentBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface DepartmentDao {

    public List<DepartmentBean> findAll();
    public DepartmentBean getById(int id);
    public void add(DepartmentBean departmentBean);
    public void deleteById(int id);
    public List<DepartmentBean> findAllByComp_id(int comp_id);
    public List<Object[]> findAllDepartments();


}
