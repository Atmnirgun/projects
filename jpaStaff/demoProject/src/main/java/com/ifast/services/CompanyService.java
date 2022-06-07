package com.ifast.services;

import com.ifast.entities.CompanyBean;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CompanyService {
    public void createCompany(CompanyBean company);
    public List<CompanyBean> getCompanies();
    public void deleteCompany(int id);
    public CompanyBean getCompany(int id);
}
