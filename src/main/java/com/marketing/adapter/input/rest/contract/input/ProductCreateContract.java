package com.marketing.adapter.input.rest.contract.input;

import com.marketing.product.util.DateTimeUtil;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreateContract {

    @NotBlank(message = "The name cannot be blank")
    private String name;

    @NotNull(message = "The status cannot be null")
    private ProductStatusContract status;

    @NotBlank(message = "The description cannot be blank")
    private String description;

    @NotBlank(message = "The image URL cannot be blank")
    private String imageUrl;

    @NotNull(message = "The category cannot be null")
    private ProductCategoryContract category;

    @NotNull
    @Pattern(regexp = "\\d+\\.\\d{2}", message = "The price must be greater than 0 and have exactly 2 decimal places")
    private String price;

    public String getCreatedAt() {
        return DateTimeUtil.getDateTimeNow();
    }

    public String getUpdatedAt() {
        return DateTimeUtil.getDateTimeNow();
    }
}