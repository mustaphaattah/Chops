package com.mtah.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class MenuControllerTest {

    @Mock
    MenuService menuService;

    @Mock
    ChefService chefService;

    @InjectMocks
    MenuController controller;

    MockMvc mockMvc;

    Chef mafuzzy;
    Menu menu;
    List<MenuCategory> categories;
    MenuCategory sides;

    final Long aChefId = 1L;
    final Long aMenuId = 2L;
    final Long aCategoryId = 3L;

    @BeforeEach
    void setUp() {
        sides = MenuCategory
                .builder()
                .build();
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

        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }

    @Test
    void createMenuTest() throws Exception{
        when(chefService.findById(anyLong())).thenReturn(mafuzzy);
        when(menuService.save(any(Menu.class))).thenReturn(menu);

        mockMvc.perform(post("/chefs/{id}/menu/create", aChefId)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(menu)))

                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(menu.getId()));

        verify(chefService).findById(anyLong());
        verify(menuService).save(any(Menu.class));
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
        when(menuService.findByChefId(anyLong())).thenReturn(menu);

        mockMvc.perform(put("/chefs/{id}/menu/update", aChefId)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(menu)))

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(menu.getId()));

        verify(menuService).findByChefId(anyLong());
    }

    @Test
    void deleteMenuTest() throws Exception{
        when(menuService.findByChefId(anyLong())).thenReturn(menu);

        mockMvc.perform(delete("/chefs/{id}/menu/delete", aChefId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(menu.getId()));

        verify(menuService).findByChefId(anyLong());
        verify(menuService, times(1)).deleteById(anyLong());
    }

    /*
     * converts a Java object into JSON representation
     */
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}