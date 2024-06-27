package com.furnycrew.furnidream.salesmanagement.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesStatisticsByProductDto {
    private String productName;
    private String color;
    private String orderAmount;
    private String totalPrice;
    private String refundAmount;
    private String totalSales;
}
