package com.kipas.miniprojectrestapi.repositories;

import com.kipas.miniprojectrestapi.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
