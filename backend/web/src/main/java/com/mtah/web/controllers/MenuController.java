package com.mtah.web.controllers;

import com.mtah.model.Chef;
import com.mtah.model.Menu.Menu;
import com.mtah.persistence.Service.ChefService;
import com.mtah.persistence.Service.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;


@RestController
@RequestMapping("/chefs/{chefId}/menu")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping({"", "/"})
    public ResponseEntity<?> createMenu(@PathVariable Long chefId,
                                        @Valid @RequestBody Menu menu){
        Menu createdMenu = menuService.create(chefId, menu);
        return new ResponseEntity<>(createdMenu, HttpStatus.CREATED);
    }

    @GetMapping({"", "/"})
    public  ResponseEntity<?> fetchMenu(@PathVariable Long chefId){
        Menu menu = menuService.findByChefId(chefId);
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

    @PatchMapping({"", "/"})
    public ResponseEntity<?> updateMenu(@PathVariable Long chefId,
                                        @Valid @RequestBody Map<String, Object> updates){
        Menu updatedMenu = menuService.update(chefId, updates);
        return new ResponseEntity<>(updatedMenu, HttpStatus.OK);
    }
    

    @DeleteMapping({"", "/"})
    public ResponseEntity<?> deleteMenu(@PathVariable Long chefId){
        Menu deletedMenu = menuService.findByChefId(chefId);
        menuService.deleteById(deletedMenu.getId());

        return new ResponseEntity<>(deletedMenu, HttpStatus.OK);
    }

}
