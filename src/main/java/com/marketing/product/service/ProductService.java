package com.marketing.product.service;

import com.marketing.adapter.input.rest.contract.output.ProductContract;
import com.marketing.product.domain.Product;
import com.marketing.product.mapper.ProductMapper;
import com.marketing.product.port.input.ProductUseCase;
import com.marketing.product.port.output.DynamodbPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ProductUseCase {

    private final DynamodbPort dynamodbPort;

    public ProductService(DynamodbPort dynamodbPort) {
        this.dynamodbPort = dynamodbPort;
    }

    @Override
    public ProductContract createProduct(Product product) {
        return ProductMapper.INSTANCE.productCreateDomainToContract(
                dynamodbPort.createProduct(
                    ProductMapper.INSTANCE.productCreateDomainToEntity(product)));
    }

    @Override
    public ProductContract updateProductByName(Product product) {
        return null;
    }

    @Override
    public void unavailableProductByName(String name) {
    }

    @Override
    public ProductContract getProductByName(String name) {
        return null;
    }

    @Override
    public List<ProductContract> getAllProducts() {
        return List.of();
    }
}