package com.ifast.dao;

import com.ifast.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Queue;


@Repository
public class ProductDaoImpl implements ProductDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public ProductDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void createProduct(Product product) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(product);
    }

    @Override
    public List<Product> getProducts() {
        Session currentSession = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = currentSession.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> root = cq.from(Product.class);
        cq.select(root);
        Query query = currentSession.createQuery(cq);
        return ((Query) query).getResultList();
    }

    @Override
    public void deleteProduct(int pid) {
        Session currentSession = sessionFactory.getCurrentSession();
        Product savedProduct = currentSession.byId(Product.class).load(pid);
        currentSession.delete(savedProduct);
    }

    @Override
    public Product getProduct(int pid) {
        Session currentSession = sessionFactory.getCurrentSession();
        Product savedProduct = currentSession.get(Product.class,pid);
        return savedProduct;
    }
}
