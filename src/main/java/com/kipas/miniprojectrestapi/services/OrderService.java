package com.kipas.miniprojectrestapi.services;

import com.kipas.miniprojectrestapi.dtos.request.OrderRequest;
import com.kipas.miniprojectrestapi.entities.Customer;
import com.kipas.miniprojectrestapi.entities.Order;
import com.kipas.miniprojectrestapi.entities.Product;
import com.kipas.miniprojectrestapi.exceptions.OutOfStockException;
import com.kipas.miniprojectrestapi.exceptions.ResourceNotFoundException;
import com.kipas.miniprojectrestapi.repositories.CustomerRepository;
import com.kipas.miniprojectrestapi.repositories.OrderRepository;
import com.kipas.miniprojectrestapi.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.*;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    @Transactional
    public Order saveOrder_old(Order order) {
        // Validate Customer
        UUID customerId = order.getCustomer().getIdCustomer();
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new EntityNotFoundException("Customer with id " + customerId + " not found"));
        order.setCustomer(customer);

        // Validate Products set Products
        List<Product> validProducts = new ArrayList<>();
        for (Product product : order.getProducts()) {
            UUID productId = product.getIdProduct();
            Product validProduct = productRepository.findById(productId).orElseThrow(() -> new EntityNotFoundException("Product with id " + productId + " not found"));
            validProducts.add(validProduct);
        }
        order.setProducts(validProducts);

        return orderRepository.save(order);
    }
    @Transactional
    public Order saveOrder(OrderRequest orderRequest) {
//        try {
            // Get customer from db
            Customer customer = customerRepository.findById(orderRequest.getCustomerId())
                    .orElseThrow(() -> new EntityNotFoundException("Customer with id " + orderRequest.getCustomerId() + " not found"));

            // Validate products and calculate total amount
            List<Product> products = new ArrayList<>();
            BigDecimal totalAmount = BigDecimal.ZERO;
            Integer qty = 0;
            for (UUID productId : orderRequest.getProductIds()) {
                Product product = productRepository.findById(productId)
                        .orElseThrow(() -> new EntityNotFoundException("Product with id " + productId + " not found"));

                // Check product stock
                if (product.getStock() < 1) {
                    throw new OutOfStockException("Product with id " + productId + " is out of stock");
                }

                // Decreasing stock after ordered
                product.setStock(product.getStock() - 1);
                productRepository.save(product);

                // Assume that product has a 'stock' field
                qty += product.getStock();

                products.add(product);

                // Assume that product has a 'price' field
                totalAmount = totalAmount.add(product.getPrice());

            }

            // Create order
            Order order = new Order();
            order.setCustomer(customer);
            order.setProducts(products);
            order.setAmount(totalAmount);
            order.setQty(qty);
            order.setStatus(Order.OrderStatus.CREATED);

            log.info("Order successfully processed: {}", order);
            return orderRepository.save(order);

//        }
//        catch (ResourceNotFoundException e) {
//            log.error("Error processing order", e);
//            throw e;
//        } catch (Exception e) {
//            log.error("Unexpected error processing order", e);
//            throw new RuntimeException("Unexpected error processing order", e);
//        }
    }
    public Order getOrder(UUID id) {
        return orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));
    }

    //... other methods
}
