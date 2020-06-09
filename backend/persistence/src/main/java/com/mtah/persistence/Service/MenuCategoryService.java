package com.mtah.persistence.Service;

import com.mtah.model.Menu.MenuCategory;
import com.mtah.persistence.Repository.MenuCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuCategoryService extends EntityService<MenuCategory, Long> {

    private final MenuCategoryRepository menuCategoryRepository;


    public MenuCategoryService(MenuCategoryRepository menuCategoryRepository) {
        this.menuCategoryRepository = menuCategoryRepository;
    }

    @Override
    public List<MenuCategory> findAll() {
        return menuCategoryRepository.findAll();
    }

    @Override
    public MenuCategory findById(Long id) {
        return menuCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        menuCategoryRepository.deleteById(id);
    }

    @Override
    public MenuCategory save(MenuCategory menuCategory) {
        return menuCategoryRepository.save(menuCategory);
    }
}
