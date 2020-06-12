package com.mtah.persistence.Service;

import com.mtah.model.Order.OrderItem;
import com.mtah.persistence.Repository.OrderItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderItemServiceTest {

    @Mock
    OrderItemRepository orderItemRepository;

    @InjectMocks
    OrderItemService orderItemService;

    OrderItem orderItem;
    Long id = 5L;

    @BeforeEach
    void setUp(){
        orderItem = OrderItem.builder().build();
        orderItem.setId(id);
    }

    @Test
    void findAllByOrderId() {
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(orderItem);

        when(orderItemRepository.findAllByOrderId(anyLong()))
                .thenReturn(orderItems);

        List orderItemList = orderItemService.findAllByOrderId(anyLong());
        verify(orderItemRepository).findAllByOrderId(anyLong());

        assertEquals(orderItemList.size(), 1);
    }

    @Test
    void findById() {
        when(orderItemRepository.findById(anyLong()))
                .thenReturn(Optional.of(orderItem));

        OrderItem foundOrderItem = orderItemService.findById(anyLong());
        verify(orderItemRepository, times(1)).findById(anyLong());

        assertEquals(orderItem.getId(), foundOrderItem.getId());
    }

    @Test
    void deleteById() {
        orderItemService.deleteById(anyLong());
        verify(orderItemRepository, times(1))
                .deleteById(anyLong());
    }

    @Test
    void save() {
        when(orderItemRepository.save(any(OrderItem.class))).thenReturn(orderItem);
        OrderItem savedOrderItem= orderItemService.save(orderItem);

        verify(orderItemRepository).save(any(OrderItem.class));
        assertEquals(orderItem.getId(), savedOrderItem.getId());
    }
}