package com.br.productservice.controller;

import com.br.productservice.dto.ProductReponse;
import com.br.productservice.dto.ProductRequest;
import com.br.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductReponse> getAllProduct(){
       return productService.getAllProduct();
    }

}
