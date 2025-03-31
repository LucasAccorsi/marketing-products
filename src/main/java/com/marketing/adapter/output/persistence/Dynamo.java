package com.marketing.adapter.output.persistence;

import com.marketing.adapter.output.persistence.entity.ProductEntity;
import com.marketing.adapter.output.persistence.repositories.ProductRepository;
import com.marketing.product.domain.Product;
import com.marketing.product.mapper.ProductMapper;
import com.marketing.product.port.output.DynamoPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Dynamo implements DynamoPort {

    private final ProductRepository productRepository;

    public Dynamo(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(ProductEntity productEntity) {
        return ProductMapper.INSTANCE.productCreateEntityToDomain(
                productRepository.save(productEntity));
    }

    @Override
    public Product updateProductByName(ProductEntity productEntity) {
        return null;
    }

    @Override
    public void unavailableProductByName(String name) {

    }

    @Override
    public Product getProductByName(String name) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
