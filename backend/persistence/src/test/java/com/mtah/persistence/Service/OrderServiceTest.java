package com.mtah.persistence.Service;

import com.mtah.model.Order.Order;
import com.mtah.persistence.Repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    OrderRepository orderRepository;

    @InjectMocks
    OrderService orderService;

    Order order;
    Long id = 3L;

    @BeforeEach
    void setUp() {
        order = Order
            .builder()
            .build();

        order.setId(id);
    }

    @Test
    void findAllByCustomerId() {
        List<Order> orders = new ArrayList<>();
        orders.add(order);

        when(orderRepository.findAllByCustomerId(anyLong())).thenReturn(orders);
        orderService.findAllByCustomerId(5L);

        verify(orderRepository, times(1)).findAllByCustomerId(anyLong());
    }

    @Test
    void findById() {

        when(orderRepository.findById(anyLong())).thenReturn(Optional.of(order));
        orderService.findById(8L);

        verify(orderRepository).findById(anyLong());
    }

    @Test
    void deleteById() {

        orderService.deleteById(8L);
        verify(orderRepository).deleteById(anyLong());
    }

    @Test
    void save() {

        when(orderRepository.save(any(Order.class))).thenReturn(order);
        orderService.save(new Order());

        verify(orderRepository, times(1)).save(any(Order.class));
    }
}