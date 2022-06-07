package com.ifast.dao;

import com.ifast.entities.CompanyBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyDao extends JpaRepository<CompanyBean,Integer>{
    /*public List<CompanyBean> findAll();
    public CompanyBean getById(int id);
    public void add(CompanyBean companyBean);
    public void update(CompanyBean companyBean);
    public void deleteById(int id);*/
}
