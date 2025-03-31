package com.marketing.product.service;

import com.marketing.adapter.input.rest.contract.output.ProductContract;
import com.marketing.product.domain.Product;
import com.marketing.product.mapper.ProductMapper;
import com.marketing.product.port.input.ProductUseCase;
import com.marketing.product.port.output.DynamodbPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductUseCase {

    private final DynamodbPort dynamodbPort;

    public ProductService(DynamodbPort dynamodbPort) {
        this.dynamodbPort = dynamodbPort;
    }

    @Override
    public ProductContract createProduct(Product product) {
        return ProductMapper.INSTANCE.productDomainToContract(
                Optional.ofNullable(findProductByName(product.getName()))
                        .orElseGet(() ->
                                dynamodbPort.createProduct(
                                        ProductMapper.INSTANCE.productCreateDomainToEntity(product))));
    }

    @Override
    public ProductContract updateProductByName(Product product) {
        return Optional.ofNullable(findProductByName(product.getName()))
                .map(productExistent ->
                        ProductMapper.INSTANCE.productDomainToContract(
                                dynamodbPort.updateProductByName(
                                        ProductMapper.INSTANCE.productUpdateDomainToEntity(product, productExistent))))
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));
    }

    @Override
    public void unavailableProductByName(String name) {
        Optional.ofNullable(findProductByName(name))
                .ifPresentOrElse(
                        productExistent ->
                                dynamodbPort.unavailableProductByName(
                                        ProductMapper.INSTANCE.productUnavailableDomainToEntity(productExistent)),
                        () -> {
                            throw new RuntimeException("Product not found");
                        });
    }

    @Override
    public ProductContract getProductByName(String name) {
        return ProductMapper.INSTANCE.productDomainToContract(
                findProductByName(name));
    }

    @Override
    public List<ProductContract> getAllProducts() {
        return ProductMapper.INSTANCE.productListDomainToContract(
                dynamodbPort.getAllProducts());
    }

    private Product findProductByName(String name) {
        return dynamodbPort.getProductByName(name);
    }
}