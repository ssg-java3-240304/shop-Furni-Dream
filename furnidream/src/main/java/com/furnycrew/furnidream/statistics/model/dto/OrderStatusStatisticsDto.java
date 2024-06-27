package com.furnycrew.furnidream.statistics.model.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
//@Setter
@ToString
public class OrderStatusStatisticsDto {
    private String orderStatus;
    private Integer statusCount;
}
