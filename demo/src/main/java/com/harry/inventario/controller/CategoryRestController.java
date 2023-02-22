package com.harry.inventario.controller;

import com.harry.inventario.model.Category;
import com.harry.inventario.response.CategoryResposeRest;
import com.harry.inventario.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class CategoryRestController {

    @Autowired
    private ICategoryService iCategoryService;

    /**
     * Get all the Categories
     * @return
     */
    @GetMapping("/categories")
    public ResponseEntity<CategoryResposeRest> searchCategories(){
        ResponseEntity<CategoryResposeRest> response = iCategoryService.search();
        return response;
    }

    /**
     * Gat categories by id
     * @param id
     * @return
     */
    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryResposeRest> searchById(@PathVariable Long id){
        ResponseEntity<CategoryResposeRest> response = iCategoryService.searchById(id);
        return response;
    }

    /**
     * Saved categories by id
     * @param category
     * @return
     */
    @PostMapping("/categories")
    public ResponseEntity<CategoryResposeRest> save(@RequestBody Category category){
        ResponseEntity<CategoryResposeRest> response = iCategoryService.save(category);
        return response;
    }
}
