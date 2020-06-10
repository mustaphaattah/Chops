package com.mtah.persistence.Service;

import com.mtah.model.Menu.MenuOption;
import com.mtah.persistence.Repository.MenuOptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuOptionService extends EntityService<MenuOption, Long> {

    private final MenuOptionRepository menuOptionRepository;

    public MenuOptionService(MenuOptionRepository menuOptionRepository) {
        this.menuOptionRepository = menuOptionRepository;
    }

    public List<MenuOption> findAllByMenuItemId(Long menuItemId) {
        return menuOptionRepository.findAllByMenuItemId(menuItemId);
    }

    @Override
    public void deleteById(Long id) {
        menuOptionRepository.deleteById(id);
    }

    @Override
    public MenuOption save(MenuOption menuOption) {
        return menuOptionRepository.save(menuOption);
    }
}
