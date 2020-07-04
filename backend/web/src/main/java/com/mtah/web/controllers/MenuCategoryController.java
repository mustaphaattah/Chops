package com.mtah.web.controllers;

import com.mtah.model.Menu.MenuCategory;
import com.mtah.persistence.Service.MenuCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/chefs/{chefId}/menu/")
public class MenuCategoryController {

    private final MenuCategoryService menuCategoryService;

    public MenuCategoryController(MenuCategoryService menuCategoryService) {
        this.menuCategoryService = menuCategoryService;
    }

    @PostMapping("/create-category")
    public ResponseEntity<?> createCategory(
        @Valid @RequestBody MenuCategory menuCategory,
        @PathVariable("chefId") Long chefId
    ) {
        MenuCategory createdMenuCategory = menuCategoryService.save(menuCategory, chefId);
        return new ResponseEntity<>(createdMenuCategory, HttpStatus.CREATED);
    }

    @PatchMapping("/category/:categoryId")
    public ResponseEntity<?> updateCategory(
        @RequestBody Map<String, String> update,
        @PathVariable("chefId") Long chefId,
        @PathVariable("categoryId") Long categoryId
    ) {
        MenuCategory updatedMenuCategory = menuCategoryService.update(chefId, categoryId, update);
        return new ResponseEntity<>(updatedMenuCategory, HttpStatus.OK);
    }

    @DeleteMapping("/category/:categoryId")
    public ResponseEntity<?> deleteCategory(
        @PathVariable("chefId") Long chefId,
        @PathVariable("categoryId") Long categoryId
    ) {
        menuCategoryService.deleteById(chefId, categoryId);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
