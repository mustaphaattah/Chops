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

    public List<MenuCategory> findAllByMenuId(long menuId) {
        return menuCategoryRepository.findAllByMenuId(menuId);
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
