package com.sst.productservicesst.controllers;

import com.sst.productservicesst.dto.ExceptionDto;
import com.sst.productservicesst.dto.FakeStoreProductDto;
import com.sst.productservicesst.models.Product;
import com.sst.productservicesst.services.FakeStoreProductService;
import com.sst.productservicesst.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private FakeStoreProductService fakeStoreProductService;
    ProductController(FakeStoreProductService fakeStoreProductService){
        this.fakeStoreProductService=fakeStoreProductService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return fakeStoreProductService.getProductById(id);

    }

    @GetMapping
    public List<Product> getAllProducts(){
        return fakeStoreProductService.getAllProducts();
    }

//    @GetMapping
//    public List<Product> getAllCategories(){
//        return null;
//    }
    
}
