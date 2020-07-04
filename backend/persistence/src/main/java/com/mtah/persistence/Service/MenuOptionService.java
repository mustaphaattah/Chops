package com.mtah.persistence.Service;

import com.mtah.model.Menu.MenuOption;
import com.mtah.persistence.Repository.MenuOptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuOptionService{

    private final MenuOptionRepository menuOptionRepository;

    public MenuOptionService(MenuOptionRepository menuOptionRepository) {
        this.menuOptionRepository = menuOptionRepository;
    }

    public List<MenuOption> findAllByMenuItemId(Long menuItemId) {
        return menuOptionRepository.findAllByMenuItemId(menuItemId);
    }

    public void deleteById(Long id) {
        menuOptionRepository.deleteById(id);
    }

    public MenuOption save(MenuOption menuOption) {
        return menuOptionRepository.save(menuOption);
    }
}
