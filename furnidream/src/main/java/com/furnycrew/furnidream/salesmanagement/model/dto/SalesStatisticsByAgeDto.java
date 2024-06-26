package com.furnycrew.furnidream.salesmanagement.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesStatisticsByAgeDto {
    private String productName;
    private String earlyToMid20s;
    private String midToLate20s;
    private String earlyToMid30s;
    private String midToLate30s;
    private String earlyToMid40s;
    private String totalSales;
}
