package com.furnycrew.furnidream.order.model.dto;

import com.furnycrew.furnidream.common.enums.OrderStatus;
import com.furnycrew.furnidream.customer.model.dto.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private long orderCode;
    private CustomerDto customerDto;
    private LocalDateTime createdAt;
    private String phone;
    private String shippingAddress;
    private int orderStatus;
    private List<OrderProductDto> orderProductList;
}
