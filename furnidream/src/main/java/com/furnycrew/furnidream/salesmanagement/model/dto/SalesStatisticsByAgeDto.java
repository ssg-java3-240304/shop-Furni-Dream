package com.furnycrew.furnidream.salesmanagement.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesStatisticsByAgeDto {
    private String productName;
    private String teenager;
    private String twenties;
    private String thirties;
    private String forties;
    private String fifties;
    private String totalSales;
}
