package com.harry.inventario.response;

import com.harry.inventario.model.Category;
import lombok.Data;

import java.util.List;
@Data
public class CategoryResponse {

    private List<Category> category;
}
