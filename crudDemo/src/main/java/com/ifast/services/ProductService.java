package com.ifast.services;

import com.ifast.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    public void createProduct(Product product);
    public List<Product> getProducts();
    public void deleteProduct(int pid);
    public Product getProduct(int pid);
}
