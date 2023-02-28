package com.harry.inventario.response;

import com.harry.inventario.model.Product;
import lombok.Data;

import java.util.List;

@Data
public class ProductResponse {
    List<Product> products;
}
