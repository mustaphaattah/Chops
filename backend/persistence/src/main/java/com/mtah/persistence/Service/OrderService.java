package com.mtah.persistence.Service;

import com.mtah.model.Order.Order;
import com.mtah.persistence.Repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAllByCustomerId(Long customerId) {
        return orderRepository.findAllByCustomerId(customerId);
    }

    public Order findById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }
}
