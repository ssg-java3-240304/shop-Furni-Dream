package com.furnycrew.furnidream.statistics.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
//@Setter
@ToString
public class OrderCountRankingDto {
    private String productCode;
    private String name;
    private String category;
    private int quantity;
}
