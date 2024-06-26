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
    private int orderAmount;
    private int totalPrice;
    private int refundAmount;
    private int totalSales;
}
