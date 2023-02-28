package com.harry.inventario.services;

import com.harry.inventario.dao.ICategoryDao;
import com.harry.inventario.dao.IProductDao;
import com.harry.inventario.model.Category;
import com.harry.inventario.model.Product;

import com.harry.inventario.response.ProductResposeRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    private final ICategoryDao iCategoryDao;

    ProductServiceImpl(ICategoryDao iCategoryDao) {
        this.iCategoryDao = iCategoryDao;
    }

    @Autowired
    private IProductDao iProductDao;

    @Override
    public ResponseEntity<ProductResposeRest> save(Product product, Long categoryId) {
        ProductResposeRest response = new ProductResposeRest();
        List<Product> list = new ArrayList<>();

        try {
            //search category to set in the product objetc
            Optional<Category> category = this.iCategoryDao.findById(categoryId);

            if (category.isPresent()) {
                product.setCategory(category.get());
            } else {
                response.setMetadata("Respuesta no Ok", "-1", "Categoria asociada no encontrada al producto");
                return new ResponseEntity<ProductResposeRest>(response, HttpStatus.NOT_FOUND);
            }
            //Save the Product
            Product productSave = iProductDao.save(product);

            if (productSave != null) {
                list.add(productSave);
                response.getProductResponse().setProducts(list);
                response.setMetadata("Respuesta Ok", "00", "Producto Guardado");

            } else {
                response.setMetadata("Respuesta no Ok", "-1", "Producto no guardado");
                return new ResponseEntity<ProductResposeRest>(response, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            response.setMetadata("Respuesta error", "-1", "Error al guardar producto");
            e.getStackTrace();
            return new ResponseEntity<ProductResposeRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<ProductResposeRest>(response, HttpStatus.OK);
    }
}
