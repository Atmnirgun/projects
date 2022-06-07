package com.ifast.services;

import com.ifast.dao.ProductDao;
import com.ifast.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

   /* @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }*/

    @Override
    public void createProduct(Product product) {
        productDao.createProduct(product);
    }

    @Override
    public List<Product> getProducts() {
        return productDao.getProducts();
    }

    @Override
    public void deleteProduct(int pid) {
        productDao.deleteProduct(pid);
    }

    @Override
    public Product getProduct(int pid) {
        return productDao.getProduct(pid);
    }
}
