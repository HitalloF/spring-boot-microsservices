package com.br.productservice.service;

import com.br.productservice.dto.ProductReponse;
import com.br.productservice.dto.ProductRequest;
import com.br.productservice.entity.Product;
import com.br.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    @Autowired
    ProductRepository productRepository;


    private ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder().name(productRequest.getName()).description(productRequest.getDescription())
                .price(productRequest.getPrice()).build();


        productRepository.save(product);
        log.info("Produto {} Salvo", product.getId());
    }


    public List<ProductReponse> getAllProduct() {
        List<Product> products = productRepository.findAll();

       return products.stream().map(this::mapToProductResponse).toList();

    }

    private ProductReponse mapToProductResponse(Product product){
    return ProductReponse.builder().
            id(product.getId()).description(product.getDescription()).
            name(product.getName()).price(product.getPrice()).build();
    }

}
