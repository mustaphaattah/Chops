package com.mtah.web.controllers;

import com.mtah.model.Menu.MenuCategory;
import com.mtah.persistence.Service.MenuCategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class MenuCategoryControllerTest {

    @Mock
    MenuCategoryService menuCategoryService;

    @InjectMocks
    MenuCategoryController menuCategoryController;

    MockMvc mockMvc;

    MenuCategory menuCategory;
    String menuCategoryName = "Chicken Dishes";

    @BeforeEach
    void setUp() {
        menuCategory = new MenuCategory();
        menuCategory.setName(menuCategoryName);
        mockMvc = MockMvcBuilders
            .standaloneSetup(menuCategoryController)
            .build();
    }

    @Test
    public void createCategory() throws Exception {
        long chefId = 2L;
        when(menuCategoryService.save(any(MenuCategory.class), anyLong())).thenReturn(menuCategory);

        mockMvc.perform(post("/api/chefs/{chefId}/menu/create-category", chefId)
            .contentType(MediaType.APPLICATION_JSON)
            .content("{ \"name\": \"Chicken Dishes\" }")
            .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value(menuCategory.getName()));

    }

}