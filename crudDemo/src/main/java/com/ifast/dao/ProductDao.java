package com.ifast.dao;

import com.ifast.entities.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductDao {
    public void createProduct(Product product);
    public List<Product> getProducts();
    public void deleteProduct(int pid);
    public Product getProduct(int pid);
}
