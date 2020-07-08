package com.mtah.persistence.Service;

import com.mtah.model.Chef;
import com.mtah.model.Menu.Menu;
import com.mtah.persistence.Repository.MenuRepository;
import com.mtah.persistence.exceptions.MenuAlreadyExistsException;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }


    public Menu findByChefId(Long id) {
        return menuRepository.findByChefId(id).orElse(null);
    }

    public Menu create(Long id, Menu menu){
        Chef chef = findByChefId(id).getChef();
        Menu createdMenu = findByChefId(id);

        if (createdMenu == null){
            createdMenu = menu;
            chef.setMenu(createdMenu);
            return menuRepository.save(createdMenu);
        }

        throw new MenuAlreadyExistsException("Chef with id: " +
                id + " already has a menu.");
    }
    public Menu update(Long id, Map<String, Object> updates){
        Menu menu = findByChefId(id);

        if (menu != null){
            updates.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Menu.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, menu, value);
            });
        }

        return menu;
    }

    public void deleteById(Long id) {
        menuRepository.deleteById(id);
    }

    public Menu save(Menu menu) {
        return menuRepository.save(menu);
    }
}
