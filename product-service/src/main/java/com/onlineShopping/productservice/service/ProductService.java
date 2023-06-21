package com.onlineShopping.productservice.service;

import com.onlineShopping.productservice.dto.ProductRequest;
import com.onlineShopping.productservice.dto.ProductResponse;
import com.onlineShopping.productservice.model.Product;
import com.onlineShopping.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("product {} is saved",product.getId());
        log.info("product {} is saved",product.getName());
    }

    public List<ProductResponse> getAllProducts() {
       List<Product> products=  productRepository.findAll();
       //create a stream to convert from product object to productResponse
        return products.stream().map(
                this::mapToProductResponse
        ).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
