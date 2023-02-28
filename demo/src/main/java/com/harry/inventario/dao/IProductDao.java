package com.harry.inventario.dao;

import com.harry.inventario.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductDao extends CrudRepository<Product, Long> {
}
