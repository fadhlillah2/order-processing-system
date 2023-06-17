package com.kipas.miniprojectrestapi.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idProduct")
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "productId", updatable = false, nullable = false)
    private UUID idProduct;

    @Column(name = "productDescription")
    private String name;

    @Column(name = "productPrice")
    private BigDecimal price;

    @Column(name = "stock")
    private Integer stock;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders = new ArrayList<>();

    // getters and setters...
}
