package com.furnycrew.furnidream.salesmanagement.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesStatisticsByAgeDto {
    private String productName;
    private int earlyToMid20s;
    private int midToLate20s;
    private int earlyToMid30s;
    private int midToLate30s;
    private int earlyToMid40s;
    private int totalSales;
}
