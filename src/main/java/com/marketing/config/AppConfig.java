package com.marketing.config;

import com.marketing.product.port.input.ProductUseCase;
import com.marketing.product.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ProductUseCase productUseCase() {
        return new ProductService();
    }
}