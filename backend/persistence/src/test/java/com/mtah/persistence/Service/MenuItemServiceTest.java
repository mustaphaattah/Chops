package com.mtah.persistence.Service;

import com.mtah.model.Menu.MenuItem;
import com.mtah.persistence.Repository.MenuItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MenuItemServiceTest {

    @Mock
    MenuItemRepository menuItemRepository;

    @InjectMocks
    MenuItemService menuItemService;

    MenuItem menuItem;
    final Long id = 3L;

    @BeforeEach
    void setUp() {
        menuItem = MenuItem
            .builder()
            .build();

        menuItem.setId(id);
    }

    @Test
    void findAllByCategoryId() {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(menuItem);

        when(menuItemRepository.findAllByCategoryId(anyLong())).thenReturn(menuItems);

        List<MenuItem> menuItemList = menuItemService.findAllByCategoryId(2L);
        verify(menuItemRepository, times(1)).findAllByCategoryId(anyLong());
        assertEquals(menuItemList.size(), 1);
    }

    @Test
    void findById() {
        when(menuItemRepository.findById(anyLong())).thenReturn(Optional.of(menuItem));

        menuItemService.findById(4L);
        verify(menuItemRepository, times(1)).findById(anyLong());
    }

    @Test
    void deleteById() {
        menuItemService.deleteById(4L);
        verify(menuItemRepository, times(1)).deleteById(anyLong());
    }

    @Test
    void save() {
        when(menuItemRepository.save(any(MenuItem.class))).thenReturn(menuItem);

        MenuItem savedMenuItem = menuItemService.save(new MenuItem());
        verify(menuItemRepository).save(any(MenuItem.class));
        assertEquals(savedMenuItem.getId(), menuItem.getId());
    }
}