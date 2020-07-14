package com.mtah.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.mtah.model.Chef;
import com.mtah.model.Menu.Menu;
import com.mtah.model.Menu.MenuCategory;
import com.mtah.persistence.Service.ChefService;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class ChefControllerTest {

    @Mock
    ChefService chefService;

    @InjectMocks
    ChefController controller;

    MockMvc mockMvc;

    Chef mafuzzy;
    Gson gson = new Gson();
    final Long chefId = 1L;
    final Long menuId = 3L;
    final String chefName = "mafuzzy";
    final String chefEmail = "mafuzzy@gmail.ca";
    final String chefPassword = "shh";

    @BeforeEach
    void setUp() {
        mafuzzy = Chef
                .builder()
                .build();
        mafuzzy.setId(chefId);
        mafuzzy.setUsername(chefName);
        mafuzzy.setPassword(chefPassword);
        mafuzzy.setEmail(chefEmail);


        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }

    /**
     * TODO: Write tests for ChefController.class
     */
    @Test
    void createChef() throws Exception{
        when(chefService.save(any(Chef.class))).thenReturn(mafuzzy);

        mockMvc.perform(post("/chefs")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(mafuzzy)))

                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(mafuzzy.getId()));

        verify(chefService).save(any(Chef.class));
    }

    @Test
    void updateChef() throws Exception {
        when(chefService.update(anyLong(), anyMap())).thenReturn(mafuzzy);

        Menu menu = Menu.builder().build();
        menu.setId(menuId);

        Map<String, Object> updates = new HashMap<>();
        updates.put("menu", menu);

        mockMvc.perform(patch("/chefs/{id}", chefId)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(updates)))

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(mafuzzy.getId()));

        verify(chefService).update(anyLong(), anyMap());
    }

    @Test
    void deleteChef() throws Exception{
        mockMvc.perform(delete("/chefs/{id}", chefId))
                .andExpect(status().isOk());

        verify(chefService, times(1)).deleteById(anyLong());
    }

    @Test
    void findChef() {
    }

    @Test
    void findAllChefs() {
    }

    @Test
    void findChefByName(){

    }

}