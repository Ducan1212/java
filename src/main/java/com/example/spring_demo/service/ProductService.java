package com.example.spring_demo.service;

import java.util.Collection;

import com.example.spring_demo.model.Product;

public interface ProductService {
    public abstract void CreateProduct(Product product);
    public abstract void UpdateProduct(String id, Product product);
    public abstract void DeleteProduct(String id);
    public abstract Collection<Product> getProducts();
}
