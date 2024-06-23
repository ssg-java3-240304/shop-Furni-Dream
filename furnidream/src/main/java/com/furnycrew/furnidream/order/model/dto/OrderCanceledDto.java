package com.furnycrew.furnidream.order.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCanceledDto {
    private long orderCode;
    private LocalDateTime createdAt;
    private int refundAmount;
}
