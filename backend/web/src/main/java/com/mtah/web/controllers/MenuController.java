package com.mtah.web.controllers;

import com.mtah.model.Chef;
import com.mtah.model.Menu.Menu;
import com.mtah.persistence.Service.ChefService;
import com.mtah.persistence.Service.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/chefs/{id}/menu")
public class MenuController {

    private final ChefService chefService;
    private final MenuService menuService;

    public MenuController(ChefService chefService, MenuService menuService) {
        this.chefService = chefService;
        this.menuService = menuService;
    }

    /*
     *
     *
    */
    @PostMapping("/create")
    public ResponseEntity<?> createMenu(@PathVariable Long id,
                                        @Valid @RequestBody Menu menu){

        Chef chef = chefService.findById(id);
        menu = new Menu();
        chef.setMenu(menu);
        Menu savedMenu = menuService.save(menu);
        return new ResponseEntity<>(savedMenu, HttpStatus.CREATED);
    }

    /*
    * Gets the menu of a chef using id
    *
    * Perhaps this be a chef get req?
    * */
    @GetMapping({"", "/"})
    public  ResponseEntity<?> fetchMenu(@PathVariable Long id){

        Menu menu = menuService.findByChefId(id);
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteMenu(@PathVariable Long id){

        Menu deletedMenu = menuService.findByChefId(id);
        menuService.deleteById(deletedMenu.getId());

        return new ResponseEntity<>(deletedMenu, HttpStatus.OK
        );
    }

}
