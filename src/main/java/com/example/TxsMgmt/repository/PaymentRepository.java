package com.example.TxsMgmt.repository;


import com.example.TxsMgmt.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // Custom query methods if needed
}
