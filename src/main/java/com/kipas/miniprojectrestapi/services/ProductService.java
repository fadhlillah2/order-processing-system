package com.kipas.miniprojectrestapi.services;

import com.kipas.miniprojectrestapi.entities.Product;
import com.kipas.miniprojectrestapi.exceptions.ResourceNotFoundException;
import com.kipas.miniprojectrestapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProduct(UUID id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
    }

    //... other methods
}
