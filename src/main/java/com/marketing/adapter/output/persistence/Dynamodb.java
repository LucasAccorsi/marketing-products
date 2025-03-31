package com.marketing.adapter.output.persistence;

import com.marketing.adapter.output.persistence.entity.ProductEntity;
import com.marketing.adapter.output.persistence.repositories.ProductRepository;
import com.marketing.product.domain.Product;
import com.marketing.product.mapper.ProductMapper;
import com.marketing.product.port.output.DynamodbPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Dynamodb implements DynamodbPort {

    private final ProductRepository productRepository;

    public Dynamodb(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(ProductEntity productEntity) {
        return saveProduct(productEntity);
    }

    @Override
    public Product updateProductByName(ProductEntity productEntity) {
        return saveProduct(productEntity);
    }

    @Override
    public void unavailableProductByName(ProductEntity productEntity) {
        saveProduct(productEntity);

    }

    @Override
    public Product getProductByName(String name) {
        return ProductMapper.INSTANCE.productEntityToDomain(
                productRepository.findByName(name));
    }

    @Override
    public List<Product> getAllProducts() {
        return ProductMapper.INSTANCE.productListEntityToDomain(
                productRepository.findAll());
    }

    private Product saveProduct(ProductEntity productEntity) {
        return ProductMapper.INSTANCE.productEntityToDomain(
                productRepository.save(productEntity));
    }
}