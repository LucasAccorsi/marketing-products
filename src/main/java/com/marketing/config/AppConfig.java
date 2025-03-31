package com.marketing.config;

import com.marketing.adapter.output.persistence.Dynamo;
import com.marketing.adapter.output.persistence.repositories.ProductRepository;
import com.marketing.product.port.input.ProductUseCase;
import com.marketing.product.port.output.DynamoPort;
import com.marketing.product.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    private final ProductRepository productRepository;

    public AppConfig(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Bean
    public DynamoPort dynamoPort() {
        return new Dynamo(productRepository);
    }

    @Bean
    public ProductUseCase productUseCase() {
        return new ProductService(dynamoPort());
    }
}