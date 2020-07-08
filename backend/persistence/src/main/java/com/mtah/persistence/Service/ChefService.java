package com.mtah.persistence.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.mtah.model.Chef;
import com.mtah.model.Menu.Menu;
import com.mtah.persistence.Repository.ChefRepository;
import com.mtah.persistence.exceptions.ChefNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ChefService {

    private final ChefRepository chefRepository;
    private final MenuService menuService;


    public ChefService(ChefRepository chefRepository, MenuService menuService) {
        this.chefRepository = chefRepository;
        this.menuService = menuService;
    }

    public Chef findById(Long id) {
        Chef chef = chefRepository.findById(id).orElse(null);
        if (chef == null) {
            throw new ChefNotFoundException("Chef Not Found");
        }
        return chef;
    }

    public List<Chef> findAll() {
        return chefRepository.findAll();
    }

    public List<String> listAsJson(List<Chef> chefs) {
        List<String> jsonList = new ArrayList<>();
        Gson gson = new Gson();

        for (Chef chef : chefs) {
            String json = gson.toJson(chef);
            jsonList.add(json);
        }

        return jsonList;
    }

    public  List<Chef> findByName(String name){
        return chefRepository.findAll()
                .stream()
                .filter(chef -> chef.getUsername().contains(name)
                || chef.getFirstName().contains(name)
                || chef.getLastName().contains(name))
                .collect(Collectors.toList());
    }

    public Chef update(Long id, Map<String, Object> updates){
        Chef chef = findById(id);

        if (chef != null){
            updates.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Chef.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, chef, value);
            });

           return chefRepository.save(chef);
        }

        throw new ChefNotFoundException("Chef with id: " + id + " does not exist.");
    }

    public void deleteById(Long id) {
        chefRepository.deleteById(id);
    }

    public Chef save(Chef chef) {
        return chefRepository.save(chef);
    }
}
