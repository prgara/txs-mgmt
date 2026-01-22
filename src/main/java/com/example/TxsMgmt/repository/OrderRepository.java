package com.example.TxsMgmt.repository;


import com.example.TxsMgmt.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // Custom query methods if needed
}
