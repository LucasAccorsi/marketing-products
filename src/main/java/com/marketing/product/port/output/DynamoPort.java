package com.marketing.product.port.output;

import com.marketing.adapter.output.persistence.entity.ProductEntity;
import com.marketing.product.domain.Product;

import java.util.List;

public interface DynamoPort {

    Product createProduct(ProductEntity productEntity);

    Product updateProductByName(ProductEntity productEntity);

    void unavailableProductByName(String name);

    Product getProductByName(String name);

    List<Product> getAllProducts();
}
