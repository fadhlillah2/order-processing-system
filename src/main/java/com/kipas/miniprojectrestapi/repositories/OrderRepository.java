package com.kipas.miniprojectrestapi.repositories;

import com.kipas.miniprojectrestapi.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}
