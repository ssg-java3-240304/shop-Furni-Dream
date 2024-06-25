package com.furnycrew.furnidream.salesmanagement.model.dto;

import com.furnycrew.furnidream.order.model.dto.OrderCanceledDto;
import com.furnycrew.furnidream.order.model.dto.OrderDto;
import com.furnycrew.furnidream.order.model.dto.OrderProductDto;
import com.furnycrew.furnidream.product.model.dto.ProductDto;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesMngDto {
    private OrderDto orderDto;
    private OrderCanceledDto orderCanceledDto;
    private ProductDto productDto;
    private List<OrderProductDto> orderProductList;

    public OrderDto getOrderDto() {
        return orderDto;
    }

    public OrderCanceledDto getOrderCanceledDto() {
        return orderCanceledDto;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public List<OrderProductDto> getOrderProductList() {
        return orderProductList;
    }

}
