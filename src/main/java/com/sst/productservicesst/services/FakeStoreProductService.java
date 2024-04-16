package com.sst.productservicesst.services;

import com.sst.productservicesst.dto.FakeStoreProductDto;
import com.sst.productservicesst.exceptions.ProductNotFoundException;
import com.sst.productservicesst.models.Category;
import com.sst.productservicesst.models.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service

public class FakeStoreProductService implements ProductService {

    @Override
    public Product getProductById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                        FakeStoreProductDto.class);
          if(fakeStoreProductDto==null){
              throw new ProductNotFoundException(id, "Please pass a valid product ID");
              }

        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    public List<Product> getAllProducts(){
        RestTemplate restTemplate=new RestTemplate();
        FakeStoreProductDto[] fakeStoreProductDto=
                restTemplate.getForObject("https://fakestoreapi.com/products",
                        FakeStoreProductDto[].class);
        List<Product> products=new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDtos: fakeStoreProductDto){
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDtos));
        }
        return products;
    }

//    public List<Category> getAllCategories(){
//        RestTemplate restTemplate=new RestTemplate();
//        FakeStoreProductDto[] fakeStoreProductDto=
//                restTemplate.getForObject("https://fakestoreapi.com/products/categories",
//                        FakeStoreProductDto[].class);
//        List<Category> categories=new ArrayList<>();
//        for(FakeStoreProductDto fakeStoreProductDto1: fakeStoreProductDto){
//            categories.add(convertFakeStoreProductDtoToCategory(fakeStoreProductDto);
//        }
//        return null;
//    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
        Category category=new Category();
        category.setDescription(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }

//    private Category convertFakeStoreProductDtoToCategory(FakeStoreProductDto fakeStoreProductDto){
//        Category category=new Category();
//        category.setId(fakeStoreProductDto.getCategoryId());
//        category.setTitle(fakeStoreProductDto.getCategoryTitle());
//        category.setDescription(fakeStoreProductDto.getCategoryDescription());
//        return category;
//    }
}