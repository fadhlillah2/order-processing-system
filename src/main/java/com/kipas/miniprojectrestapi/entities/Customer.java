package com.kipas.miniprojectrestapi.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idCustomer")
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "customerId", updatable = false, nullable = false)
    private UUID idCustomer;

    @Column(name = "customerName")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private int phone;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    // getters and setters...
}
