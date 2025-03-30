package com.marketing.adapter.input.rest.contract.input;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class ProductCreateContract {

    @NotBlank
    private String name;

    @NotNull
    private ProductStatusContract status;

    @NotBlank
    private String description;

    @NotBlank
    private String imageUrl;

    @NotNull
    private ProductCategoryContract category;

    @NotBlank
    @DecimalMin(value = "0.00", inclusive = false)
    @Digits(integer = 100, fraction=2)
    private BigDecimal price;

}