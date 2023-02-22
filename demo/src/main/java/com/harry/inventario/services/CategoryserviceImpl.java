package com.harry.inventario.services;

import com.harry.inventario.dao.ICategoryDao;
import com.harry.inventario.model.Category;
import com.harry.inventario.response.CategoryResposeRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryserviceImpl implements  ICategoryService{
    @Autowired
    private ICategoryDao iCategoryDao;
    @Override
    @Transactional(readOnly = true)
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

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoryResposeRest> searchById(Long id) {

        CategoryResposeRest response = new CategoryResposeRest();
        List<Category> listCategory = new ArrayList<>();
        try{

            Optional<Category> category = iCategoryDao.findById(id);

            if(category.isPresent()){
                listCategory.add(category.get());
                response.getCategoryResponse().setCategory(listCategory);
                response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");
            }else {
                response.setMetadata("Respuesta error", "-1", "Error al consultar el id");
                return new ResponseEntity<CategoryResposeRest>(response, HttpStatus.NOT_FOUND);
            }

        }catch (Exception e ){
            response.setMetadata("Respuesta error", "-1", "Error al consultar");
            e.getStackTrace();
            return new ResponseEntity<CategoryResposeRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<CategoryResposeRest>(response, HttpStatus.OK);

    }

    @Override
    @Transactional
    public ResponseEntity<CategoryResposeRest> save(Category category) {
        CategoryResposeRest response = new CategoryResposeRest();
        List<Category> listCategory = new ArrayList<>();
        try{

            Category categorySaved = iCategoryDao.save(category);

            if(categorySaved != null){
                listCategory.add(categorySaved);
                response.getCategoryResponse().setCategory(listCategory);
                response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");
            }else {
                response.setMetadata("Respuesta error", "-1", "Error al consultar el id");
                return new ResponseEntity<CategoryResposeRest>(response, HttpStatus.BAD_REQUEST);
            }

        }catch (Exception e ){
            response.setMetadata("Respuesta error", "-1", "Error al grabar categoria");
            e.getStackTrace();
            return new ResponseEntity<CategoryResposeRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<CategoryResposeRest>(response, HttpStatus.OK);
    }
}
