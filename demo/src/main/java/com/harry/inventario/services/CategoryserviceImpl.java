package com.harry.inventario.services;

import com.harry.inventario.dao.ICategoryDao;
import com.harry.inventario.model.Category;
import com.harry.inventario.response.CategoryResposeRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryserviceImpl implements  ICategoryService{
    @Autowired
    private ICategoryDao iCategoryDao;
    @Override
    @Transactional
    public ResponseEntity<CategoryResposeRest> search() {

        CategoryResposeRest response = new CategoryResposeRest();

        try{
            List<Category> category = (List<Category>) iCategoryDao.findAll();
            response.getCategoryResponse().setCategory(category);
            response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");
        }catch (Exception e ){
            response.setMetadata("Respuesta error", "-1", "Error al consultar");
            e.getStackTrace();
            return new ResponseEntity<CategoryResposeRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<CategoryResposeRest>(response, HttpStatus.OK);
    }
}
