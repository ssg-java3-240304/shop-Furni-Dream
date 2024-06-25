package com.furnycrew.furnidream.salesmanagement.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.YearMonth;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesMngMonthlyDto{
    private YearMonth monthly;
    private int orderAmount;
    private int totalPrice;
    private int refundAmount;
    private int totalSales;
}
