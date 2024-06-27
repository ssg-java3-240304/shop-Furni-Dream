package com.furnycrew.furnidream.order.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProductDto {
    private long orderCode;
    private long productId;
    private int quantity;
    private int price;
}
