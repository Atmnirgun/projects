package com.ifast.services;

import com.ifast.dao.CompanyDao;
import com.ifast.entities.CompanyBean;
import net.bytebuddy.dynamic.DynamicType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao companyDao;

    @Override
    public void createCompany(CompanyBean company) {
        companyDao.save(company);
    }

    @Override
    public List<CompanyBean> getCompanies() {
        return (List<CompanyBean>) companyDao.findAll();
    }

    @Override
    public void deleteCompany(int id) {
        CompanyBean savedCompany = getCompany(id);
        companyDao.delete(savedCompany);
    }

    @Override
    public CompanyBean getCompany(int id) {
         return companyDao.findById(id).get();
    }
}
