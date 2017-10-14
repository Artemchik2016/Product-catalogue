package com.catalogue.product.service;

import com.catalogue.product.model.Product;
import com.catalogue.product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("productService")
@Transactional
public  class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product findById(Long id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        saveProduct(product);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.delete(id);
    }

    @Override
    public void deleteAllProducts() {
        productRepository.deleteAll();
    }

    @Override
    public List<Product> findAllProducts() {

        return productRepository.findAll();
    }

    @Override
    public boolean isProductExist(Product product) {
        return findByName(product.getName()) != null;
    }
}
