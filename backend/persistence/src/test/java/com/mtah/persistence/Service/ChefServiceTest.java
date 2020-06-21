package com.mtah.persistence.Service;

import com.mtah.model.Chef;
import com.mtah.persistence.Repository.ChefRepository;
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
class ChefServiceTest {

    @Mock
    ChefRepository chefRepository;

    @InjectMocks
    ChefService chefService;

    Chef chef;
    Long id = 3L;

    @BeforeEach
    void setUp() {
        chef = Chef.builder().build();
        chef.setId(id);
    }

    @Test
    void findAll() {
        List<Chef> chefs = new ArrayList<>();
        chefs.add(chef);

        when(chefRepository.findAll()).thenReturn(chefs);
        chefService.findAll();

        verify(chefRepository).findAll();
        assertEquals(chefs.size(), 1);
    }

    @Test
    void findById(){
        when(chefRepository.findById(anyLong()))
                .thenReturn(Optional.of(chef));

        Chef foundChef = chefService.findById(4L);
        verify(chefRepository).findById(anyLong());
        assertEquals(chef.getId(), foundChef.getId());
    }

    @Test
    void deleteById(){
        chefService.deleteById(4l);
        verify(chefRepository).deleteById(anyLong());
    }


    @Test
    void save (){
        when(chefRepository.save(any(Chef.class))).thenReturn(chef);

        Chef savedChef = chefService.save(chef);
        verify(chefRepository).save(any(Chef.class));
        assertEquals(chef.getId(), savedChef.getId());
    }
}