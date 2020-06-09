package com.mtah.persistence.Service;

import com.mtah.model.Menu.MenuItem;
import com.mtah.persistence.Repository.MenuItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService extends EntityService<MenuItem, Long> {

    private final MenuItemRepository menuItemRepository;

    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public List<MenuItem> findAll() {
        return menuItemRepository.findAll();
    }

    @Override
    public MenuItem findById(Long id) {
        return menuItemRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        menuItemRepository.deleteById(id);
    }

    @Override
    public MenuItem save(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }
}
