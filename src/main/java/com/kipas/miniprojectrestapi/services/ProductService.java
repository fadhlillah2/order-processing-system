package com.kipas.miniprojectrestapi.services;

import com.kipas.miniprojectrestapi.entities.Product;
import com.kipas.miniprojectrestapi.exceptions.ResourceNotFoundException;
import com.kipas.miniprojectrestapi.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    public Product saveProduct(Product product) {
        log.info("Product successfully processed: {}", product);
        return productRepository.save(product);
    }

    public Product getProduct(UUID id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
    }

    //... other methods
}
