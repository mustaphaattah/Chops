package com.mtah.persistence.Service;

import com.mtah.model.Menu.MenuCategory;
import com.mtah.persistence.Repository.MenuCategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MenuCategoryServiceTest {

    @Mock
    MenuCategoryRepository menuCategoryRepository;

    @InjectMocks
    MenuCategoryService menuCategoryService;

    MenuCategory menuCategory;
    final long id = 2L;

    @BeforeEach
    void setUp() {
       menuCategory = new MenuCategory();
       menuCategory.setId(id);
    }

    @Test
    void findAllByMenuId() {
        List<MenuCategory> menuCategories = new ArrayList<>();
        menuCategories.add(menuCategory);

        when(menuCategoryRepository.findAllByMenuId(anyLong())).thenReturn(menuCategories);

        List<MenuCategory> menuCategoryList = menuCategoryService.findAllByMenuId(3L);

        verify(menuCategoryRepository, times(1)).findAllByMenuId(anyLong());
        assertEquals(menuCategoryList.size(), 1);
    }

}