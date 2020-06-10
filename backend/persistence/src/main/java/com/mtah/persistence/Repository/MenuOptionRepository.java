package com.mtah.persistence.Repository;

import com.mtah.model.Menu.MenuOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuOptionRepository extends JpaRepository<MenuOption, Long> {

    List<MenuOption> findAllByMenuItemId(Long id);
}
