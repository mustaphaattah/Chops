package com.mtah.persistence.Service;

import com.mtah.model.Chef;
import com.mtah.model.Menu.Menu;
import com.mtah.model.Menu.MenuCategory;
import com.mtah.persistence.Repository.MenuCategoryRepository;
import com.mtah.persistence.exceptions.ChefNotFoundException;
import com.mtah.persistence.exceptions.MenuCategoryNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class MenuCategoryService {

    private final MenuCategoryRepository menuCategoryRepository;
    private final ChefService chefService;

    public MenuCategoryService(MenuCategoryRepository menuCategoryRepository, ChefService chefService) {
        this.menuCategoryRepository = menuCategoryRepository;
        this.chefService = chefService;
    }

    private Chef findChef(Long chefId) {
        Chef chef = chefService.findById(chefId);
        if (chef == null) {
            throw new ChefNotFoundException("Chef with id: '" + chefId + "' not found.");
        }
        return chef;
    }

    public List<MenuCategory> findAllByMenuId(Long menuId) {
        return menuCategoryRepository.findAllByMenuId(menuId);
    }

    public void deleteById(Long chefId, Long categoryId) {
        Chef chef = findChef(chefId);
        Menu menu = chef.getMenu();

        boolean chefHasCategory = menu.getCategories()
            .stream()
            .anyMatch(category -> category.getId() == categoryId);

        if (chefHasCategory) {
            menuCategoryRepository.deleteById(categoryId);
        }

        throw new MenuCategoryNotFoundException(
            String.format("Chef with id: '%s' has no menu category with id '%s'. Cannot update non-existent menu category",
                chefId, categoryId)
        );
    }

    public MenuCategory update(Long chefId, Long categoryId, Map<String, String> update) {
        Chef chef = findChef(chefId);
        Menu menu = chef.getMenu();

        boolean chefHasCategory = menu.getCategories()
            .stream()
            .anyMatch(category -> category.getId() == categoryId);

        if (chefHasCategory) {
            MenuCategory menuCategory = menuCategoryRepository.findById(categoryId).get();
            update.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(MenuCategory.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, menuCategory, value);
            });

            menuCategoryRepository.save(menuCategory);
        }

        throw new MenuCategoryNotFoundException(
            String.format("Chef with id: '%s' has no menu category with id '%s'. Cannot update non-existent menu category",
                chefId, categoryId)
        );
    }

    public MenuCategory save(MenuCategory menuCategory, Long chefId) {
        Chef chef = findChef(chefId);
        Menu menu = chef.getMenu();
        menuCategory.setMenu(menu);
        return menuCategoryRepository.save(menuCategory);
    }
}
