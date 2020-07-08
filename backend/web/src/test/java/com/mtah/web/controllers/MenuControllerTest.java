package com.mtah.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.mtah.model.Chef;
import com.mtah.model.Menu.Menu;
import com.mtah.model.Menu.MenuCategory;
import com.mtah.persistence.Service.ChefService;
import com.mtah.persistence.Service.MenuService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class MenuControllerTest {

    @Mock
    MenuService menuService;

    @InjectMocks
    MenuController controller;

    MockMvc mockMvc;

    Chef mafuzzy;
    Menu menu;
    List<MenuCategory> categories;
    MenuCategory sides;
    Gson gson;

    final Long aChefId = 1L;
    final Long aMenuId = 2L;
    final Long aCategoryId = 3L;

    @BeforeEach
    void setUp() {
        sides = MenuCategory
                .builder()
                .build();
        sides.setName("Sides");
        sides.setId(aCategoryId);

        categories = new ArrayList<>();
        categories.add(sides);

        mafuzzy = Chef
                .builder()
                .build();
        mafuzzy.setUsername("mafuzzy");
        mafuzzy.setId(aChefId);

        menu = Menu
                .builder()
                .build();
        menu.setId(aMenuId);
        menu.setChef(mafuzzy);
        menu.setCategories(categories);

        gson = new Gson();

        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }

    @Test
    void createMenuTest() throws Exception{
        when(menuService.create(anyLong() ,any(Menu.class))).thenReturn(menu);

        mockMvc.perform(post("/chefs/{id}/menu", aChefId)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(menu)))

                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(menu.getId()));

        verify(menuService).create(anyLong() ,any(Menu.class));
    }

    @Test
    void fetchMenuTest() throws  Exception{
        when(menuService.findByChefId(anyLong())).thenReturn(menu);

        mockMvc.perform(get("/chefs/{id}/menu", aChefId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(menu.getId()));

        verify(menuService).findByChefId(anyLong());
    }

    @Test
    void updateMenuTest() throws Exception{
        when(menuService.update(anyLong(), anyMap())).thenReturn(menu);

        Map<String, Object> updates = new HashMap<>();
        updates.put("categories", sides);

        mockMvc.perform(patch("/chefs/{id}/menu/", aChefId)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(updates)))

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(menu.getId()));

        verify(menuService).update(anyLong(), anyMap());
    }

    @Test
    void deleteMenuTest() throws Exception{
        when(menuService.findByChefId(anyLong())).thenReturn(menu);

        mockMvc.perform(delete("/chefs/{id}/menu/", aChefId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(menu.getId()));

        verify(menuService).findByChefId(anyLong());
        verify(menuService, times(1)).deleteById(anyLong());
    }
}