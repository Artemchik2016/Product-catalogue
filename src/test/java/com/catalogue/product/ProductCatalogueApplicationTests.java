package com.catalogue.product;

import com.catalogue.product.model.Product;
import com.catalogue.product.service.ProductService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCatalogueApplicationTests {

    @Autowired
    private ProductService productService;

    private List<Product> productList = new ArrayList<>();


	@After
    public void after(){
        ListIterator<Product> li = productList.listIterator(productList.size());
        while(li.hasPrevious()) {
            Product entity = li.previous();
            productService.deleteProductById(entity.getId());
        }
    }


    @Test
    public void testAdd() {
        Product product = createNewProduct();
        productService.saveProduct(product);
        productList.add(product);
        Product createdProduct = productService.findById(product.getId());
        Assert.assertEquals("Boots", createdProduct.getName());
    }

    @Test
    public void testUpdate() {
        Product product = createNewProduct();
        product.setName("Shoes");
        productService.saveProduct(product);
        productList.add(product);
        Product updatedProduct = productService.findById(product.getId());
        Assert.assertNotNull(updatedProduct);
    }


    @Test
    public void testDelete() {
        Product product = createNewProduct();
        productService.saveProduct(product);
        productService.deleteProductById(product.getId());
        Assert.assertNull(productService.findById(product.getId()));
    }


    private Product createNewProduct() {
        Product product = new Product();
        product.setName("Boots");
        product.setPrice(BigDecimal.valueOf(250));
        return product;
    }


}
