package com.marketing.adapter.input.rest.contract.input;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
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
public class ProductUpdateContract {

    private ProductStatusContract status;
    private String description;
    private String imageUrl;
    private ProductCategoryContract category;

    @DecimalMin(value = "0.00", inclusive = false)
    @Digits(integer = 100, fraction=2)
    private BigDecimal price;
}