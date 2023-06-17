package com.kipas.miniprojectrestapi.services;

import com.kipas.miniprojectrestapi.entities.Customer;
import com.kipas.miniprojectrestapi.entities.Order;
import com.kipas.miniprojectrestapi.entities.Product;
import com.kipas.miniprojectrestapi.exceptions.OutOfStockException;
import com.kipas.miniprojectrestapi.exceptions.ResourceNotFoundException;
import com.kipas.miniprojectrestapi.repositories.CustomerRepository;
import com.kipas.miniprojectrestapi.repositories.OrderRepository;
import com.kipas.miniprojectrestapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Order saveOrder(Order order) {
        // Validate Customer
        UUID customerId = order.getCustomer().getIdCustomer();
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new EntityNotFoundException("Customer with id " + customerId + " not found"));
        order.setCustomer(customer);

        // Validate Products set Products
        Set<Product> validProducts = new HashSet<>();
        for (Product product : order.getProducts()) {
            UUID productId = product.getIdProduct();
            Product validProduct = productRepository.findById(productId).orElseThrow(() -> new EntityNotFoundException("Product with id " + productId + " not found"));
            validProducts.add(validProduct);
        }
        order.setProducts(validProducts);

        return orderRepository.save(order);
    }
    public Order getOrder(UUID id) {
        return orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));
    }

    //... other methods
}
