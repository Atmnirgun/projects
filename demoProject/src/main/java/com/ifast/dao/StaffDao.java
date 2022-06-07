package com.ifast.dao;

import com.ifast.entities.StaffBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffDao extends JpaRepository<StaffBean,Integer> {

    @Query(value = "SELECT * from staff s where s.dept_id=?1",nativeQuery = true)
    public List<StaffBean> findAllByDept_id(int id);
}
