package com.example.TxsMgmt.service;


import com.example.TxsMgmt.model.Order;
import com.example.TxsMgmt.model.Payment;
import com.example.TxsMgmt.repository.OrderRepository;
import com.example.TxsMgmt.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentRepository paymentRepository;


    @Transactional(rollbackFor = RuntimeException.class)
    public Order createOrder(Order order) {

        Order savedOrder = orderRepository.save(order);

        processPayment(savedOrder);

        return savedOrder;
    }



    public void processPayment(Order order) {
        Payment payment = new Payment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());

        // Simulate a failure during payment processing
        if (order.getPrice() > 1000) {
            throw new RuntimeException("Payment processing failed");
        }

        paymentRepository.save(payment);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get Order by ID
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    // Update Order
    public Order updateOrder(Long id, Order order) {
        Optional<Order> existingOrder = getOrderById(id);
        if (existingOrder.isPresent()) {
            Order updatedOrder = existingOrder.get();
            updatedOrder.setProductName(order.getProductName());
            updatedOrder.setPrice(order.getPrice());
            return orderRepository.save(updatedOrder);
        }
        return null;  // Order not found
    }

    // Delete Order
    public boolean deleteOrder(Long id) {
        Optional<Order> existingOrder = getOrderById(id);
        if (existingOrder.isPresent()) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;  // Order not found
    }
}
