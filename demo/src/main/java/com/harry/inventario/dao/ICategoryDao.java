package com.harry.inventario.dao;

import com.harry.inventario.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryDao extends CrudRepository<Category, Long> {
}
