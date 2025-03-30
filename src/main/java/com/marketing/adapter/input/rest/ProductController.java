package com.marketing.adapter.input.rest;


import com.marketing.adapter.input.rest.contract.input.ProductCreateContract;
import com.marketing.adapter.input.rest.contract.input.ProductUpdateContract;
import com.marketing.adapter.input.rest.contract.output.ProductContract;
import com.marketing.product.mapper.ProductMapper;
import com.marketing.product.port.input.ProductUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductUseCase productUseCase;

    public ProductController(ProductUseCase productUseCase) {
        this.productUseCase = productUseCase;
    }

    @PostMapping
    public ResponseEntity<ProductContract> createProduct(
            @Valid @RequestBody final ProductCreateContract productCreateContract,
            HttpServletRequest request) {
        return ResponseEntity.created(URI.create(request.getRequestURL().toString()))
                .body(productUseCase.createProduct(
                        ProductMapper.INSTANCE.productCreateContractToDomain(productCreateContract)));
    }

    @PatchMapping(path = "/{name}")
    public ResponseEntity<ProductContract> updateProductByName(
            @PathVariable(name = "name") final String name,
            @Valid @RequestBody final ProductUpdateContract productUpdateContract) {
        return ResponseEntity.ok()
                .body(productUseCase.updateProductByName(
                        ProductMapper.INSTANCE.productUpdateContractToDomain(name, productUpdateContract)));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/{name}")
    public void unavailableProductByName(
            @PathVariable(name = "name") final String name) {
        productUseCase.unavailableProductByName(name);
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<ProductContract> getProductByName(
            @PathVariable(name = "name") final String name) {
        return ResponseEntity.ok()
                .body(productUseCase.getProductByName(name));
    }

    @GetMapping
    public ResponseEntity<List<ProductContract>> getAllProducts() {
        return ResponseEntity.ok()
                .body(productUseCase.getAllProducts());
    }
}
