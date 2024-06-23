package com.furnycrew.furnidream.order.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProductDto {
    private long order_code;
    private long product_id;
    private int quantity;
    private int price;
}
