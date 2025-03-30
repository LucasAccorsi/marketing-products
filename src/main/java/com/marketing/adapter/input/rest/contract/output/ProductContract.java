package com.marketing.adapter.input.rest.contract.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductContract {
    private BigInteger id;
    private ProductStatusContract status;
    private String name;
    private String description;
    private String imageUrl;
    private BigDecimal price;
    private ProductCategoryContract category;
    private String createdAt;
    private String updatedAt;
}