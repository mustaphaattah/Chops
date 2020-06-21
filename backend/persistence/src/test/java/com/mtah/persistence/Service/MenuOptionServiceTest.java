package com.mtah.persistence.Service;

import com.mtah.model.Menu.MenuOption;
import com.mtah.persistence.Repository.MenuOptionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MenuOptionServiceTest {

    @Mock
    MenuOptionRepository menuOptionRepository;

    @InjectMocks
    MenuOptionService menuOptionService;

    MenuOption menuOption;
    final long id = 6L;

    @BeforeEach
    void setUp() {
        menuOption = MenuOption
            .builder()
            .build();

        menuOption.setId(id);
    }

    @Test
    void findAllByMenuItemId() {
        List<MenuOption> menuOptions = new ArrayList<>();
        menuOptions.add(menuOption);

        when(menuOptionRepository.findAllByMenuItemId(anyLong())).thenReturn(menuOptions);
        menuOptionService.findAllByMenuItemId(8L);

        verify(menuOptionRepository).findAllByMenuItemId(anyLong());
    }

    @Test
    void deleteById() {
        menuOptionService.deleteById(9L);
        verify(menuOptionRepository).deleteById(anyLong());
    }

    @Test
    void save() {
        when(menuOptionRepository.save(any(MenuOption.class))).thenReturn(menuOption);

        MenuOption savedMenuOption = menuOptionService.save(new MenuOption());
        verify(menuOptionRepository).save(any(MenuOption.class));
        assertEquals(savedMenuOption.getId(), menuOption.getId());
    }
}