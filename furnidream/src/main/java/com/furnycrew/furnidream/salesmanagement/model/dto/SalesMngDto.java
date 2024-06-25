package com.furnycrew.furnidream.salesmanagement.model.dto;

import com.furnycrew.furnidream.order.model.dto.OrderCanceledDto;
import com.furnycrew.furnidream.order.model.dto.OrderDto;
import com.furnycrew.furnidream.order.model.dto.OrderProductDto;
import com.furnycrew.furnidream.product.model.dto.ProductDto;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesMngDto {
//    private OrderDto orderDto;
//    private List<OrderProductDto> orderProductList;

    private LocalDate createdAt;
    private int orderAmount;
    private int totalPrice;
    private int refundAmount;
    private int totalSales;

//    public List<OrderProductDto> getOrderProductList() {
//        return orderProductList;
//    }

//    private LocalDate localDate;
//    private
//
}
