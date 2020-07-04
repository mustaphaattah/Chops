package com.mtah.persistence.Service;

import com.mtah.model.Menu.MenuItem;
import com.mtah.persistence.Repository.MenuItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {

    private final MenuItemRepository menuItemRepository;

    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public List<MenuItem> findAllByCategoryId(long categoryId) {
        return menuItemRepository.findAllByCategoryId(categoryId);
    }

    public MenuItem findById(Long id) {
        return menuItemRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        menuItemRepository.deleteById(id);
    }

    public MenuItem save(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }
}
