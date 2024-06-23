package com.furnycrew.furnidream.order.model.dao;

import com.furnycrew.furnidream.order.model.dto.OrderDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    public List<OrderDto> findAllOrder();
}
