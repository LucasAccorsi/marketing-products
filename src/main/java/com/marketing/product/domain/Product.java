package com.marketing.product.domain;

import com.marketing.product.domain.enums.ProductCategory;
import com.marketing.product.domain.enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String name;
    private ProductStatus status;
    private String description;
    private String imageUrl;
    private BigDecimal price;
    private ProductCategory category;
    private String createdAt;
    private String updatedAt;
}