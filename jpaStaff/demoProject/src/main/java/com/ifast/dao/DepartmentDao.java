package com.ifast.dao;

import com.ifast.dto.DepartmentDto;
import com.ifast.entities.DepartmentBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentDao extends JpaRepository<DepartmentBean,Integer> {

    @Query(value = "SELECT * FROM DEPARTMENT D WHERE D.COMP_ID=?1",nativeQuery = true)
    public List<DepartmentBean> findByComp_id(int comp_id);

    @Query(value = "SELECT d.dept_id,d.name,c.name as comp_name from DEPARTMENT d INNER JOIN company c on d.comp_id=c.comp_id",nativeQuery = true)
    public List<Object[]> getDepartments();




}
