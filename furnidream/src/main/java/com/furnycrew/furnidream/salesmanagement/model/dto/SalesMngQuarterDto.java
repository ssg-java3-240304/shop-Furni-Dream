package com.furnycrew.furnidream.salesmanagement.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesMngQuarterDto {
    private String dateQuarter;
    private int orderAmount;
    private int totalPrice;
    private int refundAmount;
    private int totalSales;
}
