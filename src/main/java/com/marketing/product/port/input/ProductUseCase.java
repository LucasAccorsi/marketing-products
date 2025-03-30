package com.marketing.product.port.input;

import com.marketing.adapter.input.rest.contract.output.ProductContract;
import com.marketing.product.domain.Product;

import java.util.List;

public interface ProductUseCase {

    ProductContract createProduct(Product product);

    ProductContract updateProductByName(Product product);

    void unavailableProductByName(String name);

    ProductContract getProductByName(String name);

    List<ProductContract> getAllProducts();
}
