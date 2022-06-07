package com.ifast.dao;

import com.ifast.entities.DepartmentBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentDao extends JpaRepository<DepartmentBean,Integer> {

    @Query(value = "SELECT * FROM DEPARTMENT D WHERE D.COMP_ID=?1",nativeQuery = true)
    public List<DepartmentBean> findByComp_id(int comp_id);
}
