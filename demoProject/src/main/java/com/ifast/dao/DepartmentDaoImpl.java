package com.ifast.dao;

import com.ifast.entities.CompanyBean;
import com.ifast.entities.DepartmentBean;
import com.ifast.entities.StaffBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<DepartmentBean> findAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(DepartmentBean.class);
        Root<DepartmentBean> root = cq.from(DepartmentBean.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public DepartmentBean getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        DepartmentBean departmentBean = session.get(DepartmentBean.class,id);
        return departmentBean;
    }

    @Override
    public void add(DepartmentBean departmentBean) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(departmentBean);
    }

    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        DepartmentBean departmentBean = session.get(DepartmentBean.class,id);
        session.delete(departmentBean);
    }

    @Override
    public List<DepartmentBean> findAllByComp_id(int comp_id) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<DepartmentBean> cq = cb.createQuery(DepartmentBean.class);
        Root<DepartmentBean> root = cq.from(DepartmentBean.class);
        cq.select(root);
        cq.where(session.getCriteriaBuilder().equal(root.get("comp_id"),comp_id));
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public List<Object[]> findAllDepartments() {
        System.out.println("called");
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createSQLQuery("SELECT d.dept_id,d.name,c.name as comp_name from DEPARTMENT d INNER JOIN company c on d.comp_id=c.comp_id");
        return query.getResultList();
    }
}
