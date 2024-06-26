package com.furnycrew.furnidream.product.model.dto;

import com.furnycrew.furnidream.common.enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long productId;
    private String productName;
    private String productImage;
    private String category;
    private Integer costPrice;
    private Integer retailPrice;
    private Integer stock;
    private String description;
    private String productCode;
    private Integer discountRate;
    private Integer shippingFee;
    private ProductStatus productStatus;
    private String color;
    private Integer size;
}
