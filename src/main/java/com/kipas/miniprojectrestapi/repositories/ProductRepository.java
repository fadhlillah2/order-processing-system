package com.kipas.miniprojectrestapi.repositories;

import com.kipas.miniprojectrestapi.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
