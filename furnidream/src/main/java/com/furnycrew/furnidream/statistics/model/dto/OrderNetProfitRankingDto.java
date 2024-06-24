package com.furnycrew.furnidream.statistics.model.dto;

import lombok.Getter;
import lombok.ToString;

// 코드별로 가격이 동일로 가정
@Getter
//@Setter
@ToString
public class OrderNetProfitRankingDto {
    private String productCode;
    private String name;
    private String category;
    private int netProfit;
}
