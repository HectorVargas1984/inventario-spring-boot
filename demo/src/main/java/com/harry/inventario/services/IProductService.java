package com.harry.inventario.services;

import com.harry.inventario.model.Product;
import com.harry.inventario.response.ProductResposeRest;
import org.springframework.http.ResponseEntity;

public interface IProductService {

    public ResponseEntity<ProductResposeRest> save(Product product, Long categoryId);
}
