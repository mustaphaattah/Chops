package com.mtah.persistence.Service;

import com.mtah.model.Menu.Menu;
import com.mtah.persistence.Repository.MenuRepository;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public Menu findByChefId(Long id) {
        return menuRepository.findByChefId(id).orElse(null);
    }

    public void deleteById(Long id) {
        menuRepository.deleteById(id);
    }

    public Menu save(Menu menu) {
        return menuRepository.save(menu);
    }
}
