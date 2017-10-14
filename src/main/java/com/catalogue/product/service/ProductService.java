package com.catalogue.product.service;

import com.catalogue.product.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductService {

    Product findById(Long id);

    Product findByName(String name);

    void saveProduct(Product product);

    void updateProduct(Product product);

    void deleteProductById(Long id);

    void deleteAllProducts();

    List<Product> findAllProducts();

    boolean isProductExist(Product product);
}
