package com.mtah.web.controllers;

import com.mtah.model.Chef;
import com.mtah.model.Menu.Menu;
import com.mtah.model.Person;
import com.mtah.persistence.Service.ChefService;
import com.mtah.persistence.Service.MenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/chefs")
public class ChefController {

    public final ChefService chefService;

    public ChefController(ChefService chefService) {
        this.chefService = chefService;
    }

    /*
     * Creating a chef creates a new empty menu for the chef as well
     */
    @PostMapping("/create-chef")
    public ResponseEntity<?> createChef(@Valid @RequestBody Chef chef) {
        Chef createdChef = chefService.save(chef);
        return new ResponseEntity<>(createdChef, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateChef(@PathVariable Long id,
                                        @Valid @RequestBody Map<String, Object> updates) {

        Chef updatedChef = chefService.update(id, updates);
        return new ResponseEntity<>(updatedChef, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteChef(@PathVariable Long id){

        chefService.deleteById(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findChef(@PathVariable Long id){
        Chef chef = chefService.findById(id);
        return new ResponseEntity<>(chef, HttpStatus.OK);
    }

    @GetMapping({"", "/"})
    public ResponseEntity<?> findAllChefs(){
        List<Chef> chefs = chefService.findAll();
        List<String> jsonChefs = chefService.listAsJson(chefs);
        return new ResponseEntity<>(chefs, HttpStatus.OK);
    }

    @GetMapping("/search")
    private ResponseEntity<?> findChefByName(@RequestParam String name){
        List<Chef> chefs = chefService.findByName( name);
        return new ResponseEntity<>( chefs,HttpStatus.OK);
    }

//    @GetMapping("")
//    private ResponseEntity<?> getChefByTag(@RequestParam String aTag){
//
//    }
}
