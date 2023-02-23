package com.harry.inventario.services;


import com.harry.inventario.model.Category;
import com.harry.inventario.response.CategoryResposeRest;
import org.springframework.http.ResponseEntity;

public interface ICategoryService {

    public ResponseEntity<CategoryResposeRest> search();

    public ResponseEntity<CategoryResposeRest> searchById(Long id);

    public ResponseEntity<CategoryResposeRest> save(Category category);

    public ResponseEntity<CategoryResposeRest> update(Category category, Long id);
}
