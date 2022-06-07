package com.ifast.dao;

import com.ifast.entities.StaffBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StaffDao {
    public List<StaffBean> findAll();
    public StaffBean getById(int id);
    public void add(StaffBean staffBean);
    public void deleteById(int id);
    public List<StaffBean> findAllByDept_id(int id);
    public List<Object[]> findAllByDepNameAndSupName();
    public List<StaffBean> findAllStaffBySupervisor_id(int id);
}
