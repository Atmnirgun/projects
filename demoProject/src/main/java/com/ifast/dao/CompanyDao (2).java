package com.ifast.dao;

import com.ifast.entities.CompanyBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CompanyDao {
    public List<CompanyBean> findAll();
    public CompanyBean getById(int id);
    public void add(CompanyBean companyBean);
    public void deleteById(int id);
}
