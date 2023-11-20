package com.enigma.wms_api.model.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private String productId;
    private String productCode;
    private String productName;
    private Integer minPrice;
    private Integer maxPrice;
    private BigDecimal price;
    private Integer page;
    private Integer size;
    private String branchId;
}
