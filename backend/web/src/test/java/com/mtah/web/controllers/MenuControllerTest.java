package com.mtah.web.controllers;

import com.google.gson.Gson;
import com.mtah.model.Chef;
import com.mtah.model.Menu.Menu;
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

    final Long aChefId = 1L;
    final Long aMenuId = 2L;

    @BeforeEach
    void setUp() {
        mafuzzy = Chef
                .builder()
                .build();
        mafuzzy.setUsername("mafuzzy");
        mafuzzy.setId(aChefId);

        menu = Menu
                .builder()
                .build();
        menu.setId(aMenuId);

        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }

    @Test
    void createMenuTest() throws Exception{
        when(chefService.findById(anyLong())).thenReturn(mafuzzy);
        when(menuService.save(any(Menu.class))).thenReturn(menu);

        Gson gson = new Gson();
        String json = gson.toJson(menu);

        mockMvc.perform(post("/chefs/{id}/menu/create", aChefId)
                .accept(MediaType.APPLICATION_JSON).content(json)
                .contentType(MediaType.APPLICATION_JSON))

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
    void deleteMenuTest() throws Exception{
        when(menuService.findByChefId(anyLong())).thenReturn(menu);

        mockMvc.perform(delete("/chefs/{id}/menu/delete", aChefId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(menu.getId()));

        verify(menuService).findByChefId(anyLong());
        verify(menuService, times(1)).deleteById(anyLong());
    }
}