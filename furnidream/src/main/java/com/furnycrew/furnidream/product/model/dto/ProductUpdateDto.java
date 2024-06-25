package com.furnycrew.furnidream.product.model.dto;

import com.furnycrew.furnidream.common.enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductUpdateDto {
    private String productName;
    private String productImage;
    private String category;
    private int costPrice;
    private int retailPrice;
    private int stock;
    private String description;
    private String productCode;
    private int discountRate;
    private int shippingFee;
    private ProductStatus productStatus;
    private String color;
    private int size;

    public ProductDto toProductDto() {
        return new ProductDto(null, this.productName, this.productImage, this.category, this.costPrice, this.retailPrice,
                this.stock, this.description, this.productCode, this.discountRate, this.shippingFee, this.productStatus,
                this.color, this.size);
    }
}
