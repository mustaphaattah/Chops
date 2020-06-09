package com.mtah.persistence.Service;

import com.mtah.model.Menu.Menu;
import com.mtah.persistence.Repository.MenuRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MenuServiceTest {

    @Mock
    MenuRepository menuRepository;

    @InjectMocks
    MenuService menuService;

    Menu menu;
    final Long id = 1L;

    @BeforeEach
    void setUp() {
        menu = Menu
            .builder()
            .build();
        menu.setId(id);
    }

    @Test
    void findById() {
        when(menuRepository.findByChefId(anyLong())).thenReturn(Optional.of(menu));

        Menu returnedMenu = menuService.findById(2L);

        verify(menuRepository, times(1)).findByChefId(anyLong());
    }

    @Test
    void deleteById() {
        menuService.deleteById(3L);
        verify(menuRepository, times(1)).deleteById(anyLong());
    }

    @Test
    void save() {
        when(menuRepository.save(any(Menu.class))).thenReturn(menu);

        Menu savedMenu = menuService.save(new Menu());
        verify(menuRepository, times(1)).save(any(Menu.class));
        assertEquals(savedMenu.getId(), menu.getId());
    }
}