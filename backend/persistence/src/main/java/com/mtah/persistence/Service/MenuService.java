package com.mtah.persistence.Service;

import com.mtah.model.Menu.Menu;
import com.mtah.persistence.Repository.MenuRepository;
import org.springframework.stereotype.Service;

@Service
public class MenuService extends EntityService<Menu, Long> {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public Menu findById(Long id) {
        return menuRepository.findByChefId(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        menuRepository.deleteById(id);
    }

    @Override
    public Menu save(Menu menu) {
        return menuRepository.save(menu);
    }
}
