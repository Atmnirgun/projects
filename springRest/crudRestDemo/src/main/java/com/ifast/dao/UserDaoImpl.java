package com.ifast.dao;

import com.ifast.entities.User;
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
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        User savedUser = session.get(User.class,id);
        return savedUser;
    }

    @Override
    public User save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
        return user;
    }

    @Override
    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return ((Query) query).getResultList();
    }

    @Override
    public Boolean delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        User savedUser = session.get(User.class,id);
        if(savedUser != null){
            session.delete(savedUser);
            return true;
        }
        return false;
    }
}
