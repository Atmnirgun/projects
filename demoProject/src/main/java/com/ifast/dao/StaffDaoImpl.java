package com.ifast.dao;

import com.ifast.entities.StaffBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class StaffDaoImpl implements StaffDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<StaffBean> findAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<StaffBean> cq = cb.createQuery(StaffBean.class);
        Root<StaffBean> root = cq.from(StaffBean.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return  query.getResultList();
    }

    @Override
    public StaffBean getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        StaffBean staff = session.get(StaffBean.class,id);
        return staff;
    }

    @Override
    public void add(StaffBean staffBean) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(staffBean);
    }

    @Override
    public void deleteById(int id) {
       Session session = sessionFactory.getCurrentSession();
       StaffBean staff = session.get(StaffBean.class,id);
       session.delete(staff);
    }

    @Override
    public List<StaffBean> findAllByDept_id(int id) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(StaffBean.class);
        Root<StaffBean> root = cq.from(StaffBean.class);
        cq.select(root);
        cq.where(session.getCriteriaBuilder().equal(root.get("dept_id"),id));
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public List<Object[]> findAllByDepNameAndSupName() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("select s.staff_id,s.name,s.gender,s.nric,s.tel_hp,s.dob,s.join_date,d.name as dept_name,d.comp_id as comp_id,sd.name as sup_name from staff s inner join department d on s.dept_id=d.dept_id inner join staff sd on s.supervisor_id=sd.staff_id");
        return query.getResultList();
    }

    @Override
    public List<StaffBean> findAllStaffBySupervisor_id(int id) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(StaffBean.class);
        Root<StaffBean> root = cq.from(StaffBean.class);
        cq.select(root);
        cq.where(session.getCriteriaBuilder().equal(root.get("supervisor_id"),id));
        Query query = session.createQuery(cq);
        return query.getResultList();
    }
}
