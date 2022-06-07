package com.ifast.dao;

import com.ifast.entities.CompanyBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CompanyDaoImpl implements CompanyDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<CompanyBean> findAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(CompanyBean.class);
        Root<CompanyBean> root = cq.from(CompanyBean.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public CompanyBean getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        CompanyBean companyBean = session.get(CompanyBean.class,id);
        return companyBean;
    }

    @Override
    public void add(CompanyBean companyBean) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(companyBean);
    }


    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        CompanyBean companyBean = session.get(CompanyBean.class,id);
        session.delete(companyBean);
    }
}
