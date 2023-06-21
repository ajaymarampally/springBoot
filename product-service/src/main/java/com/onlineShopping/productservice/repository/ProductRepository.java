package com.onlineShopping.productservice.repository;

import com.onlineShopping.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {

}
