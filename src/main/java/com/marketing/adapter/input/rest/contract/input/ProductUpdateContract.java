package com.marketing.adapter.input.rest.contract.input;

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
public class ProductUpdateContract {

    private ProductStatusContract status;
    private String description;
    private String imageUrl;
    private ProductCategoryContract category;

    @Pattern(regexp = "\\d+\\.\\d{2}", message = "The price must be greater than 0 and have exactly 2 decimal places")
    private String price;

    public String getUpdatedAt() {
        return this.getDateTimeNow();
    }

    private String getDateTimeNow() {
        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
    }
}