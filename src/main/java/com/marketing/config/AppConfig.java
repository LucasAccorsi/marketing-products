package com.marketing.config;

import com.marketing.adapter.output.persistence.Dynamodb;
import com.marketing.adapter.output.persistence.repositories.ProductRepository;
import com.marketing.product.port.input.ProductUseCase;
import com.marketing.product.port.output.DynamodbPort;
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
    public DynamodbPort dynamoPort() {
        return new Dynamodb(productRepository);
    }

    @Bean
    public ProductUseCase productUseCase() {
        return new ProductService(dynamoPort());
    }
}