package com.harry.inventario.services;


import com.harry.inventario.response.CategoryResposeRest;
import org.springframework.http.ResponseEntity;

public interface ICategoryService {

    public ResponseEntity<CategoryResposeRest> search();
}
