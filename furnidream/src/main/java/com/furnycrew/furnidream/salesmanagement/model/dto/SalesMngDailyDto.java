package com.furnycrew.furnidream.salesmanagement.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

import java.time.LocalDate;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesMngDailyDto {
    private LocalDate createdAt;
    private String orderAmount;
    private String totalPrice;
    private String refundAmount;
    private String totalSales;
}
