package com.example.spring_demo.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.spring_demo.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
   private static Map<String, Product> productRepo = new HashMap<>();

    static {
        Product test1 = new Product();
        test1.setId("1");
        test1.setName("test1");
        productRepo.put(test1.getId(), test1);

        Product test2 = new Product();
        test2.setId("2");
        test2.setName("test2");

        productRepo.put(test2.getId(), test2);
    }

    @Override
    public void CreateProduct(Product product) {
        productRepo.put(product.getId(), product);
    }

    @Override
    public void UpdateProduct(String id, Product product) {
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
    }

    @Override
    public void DeleteProduct(String id) {
        productRepo.remove(id);
    }

    @Override
    public Collection<Product> getProducts() {
        return productRepo.values();
    }
}
