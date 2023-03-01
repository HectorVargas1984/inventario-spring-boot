package com.harry.inventario.controller;

import com.harry.inventario.model.Product;
import com.harry.inventario.response.ProductResposeRest;
import com.harry.inventario.services.IProductService;
import com.harry.inventario.util.Util;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/v1")
public class ProductRestController {

    private IProductService iProductService;

    ProductRestController(IProductService iProductService){
        this.iProductService = iProductService;
    }

    /**
     * Save Product
     * @param picture
     * @param name
     * @param price
     * @param account
     * @param categoryID
     * @return
     * @throws IOException
     */
    @PostMapping("/products")
    public ResponseEntity<ProductResposeRest> save(
            @RequestParam("picture")MultipartFile picture,
            @RequestParam("name") String name,
            @RequestParam("price") int price,
            @RequestParam("account") int account,
            @RequestParam("categoryID") Long categoryID
            ) throws IOException {
        Product product = new Product();
        product.setName(name);
        product.setAccount(account);
        product.setPrice(price);
        product.setPicture(Util.compressZLib(picture.getBytes()));

        ResponseEntity<ProductResposeRest> response = iProductService.save(product, categoryID);
        return response;
    }

    /**
     * Search by id
     * @param id
     * @return
     */
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResposeRest> searchById(@PathVariable Long id){

        ResponseEntity<ProductResposeRest> response = iProductService.searchById(id);

        return response;
    }

    /**
     * Search by name
     * @param name
     * @return
     */
    @GetMapping("/products/filter/{name}")
    public ResponseEntity<ProductResposeRest> searchbyName(@PathVariable String name){

        ResponseEntity<ProductResposeRest> response = iProductService.searchByName(name);

        return response;
    }

    /**
     * Delete product by id
     * @param id
     * @return
     */
    @DeleteMapping("/products/{id}")
    public ResponseEntity<ProductResposeRest> deleteById(@PathVariable Long id){

        ResponseEntity<ProductResposeRest> response = iProductService.deleteById(id);

        return response;
    }

    /**
     * search all
     * @return
     */
    @GetMapping("/products")
    public ResponseEntity<ProductResposeRest> search(){

        ResponseEntity<ProductResposeRest> response = iProductService.search();

        return response;
    }
}
