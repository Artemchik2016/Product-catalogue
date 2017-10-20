package com.catalogue.product;

import com.catalogue.product.configuration.JpaConfiguration;
import com.catalogue.product.configuration.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@Import({JpaConfiguration.class, ResourceConfig.class})
@SpringBootApplication(scanBasePackages={"com.catalogue.product"})
public class ProductCatalogueApplication {


	@Bean
	public MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductCatalogueApplication.class, args);
	}
}
