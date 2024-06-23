package com.furnycrew.furnidream.order.model.dao;

import com.furnycrew.furnidream.common.SearchCriteria;
import com.furnycrew.furnidream.order.model.dto.OrderDto;
import com.furnycrew.furnidream.order.model.dto.OrderProductDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
@Mapper
public interface OrderMapper {
    public List<OrderDto> findOrdersByDateTime(SearchCriteria searchCriteria);
}
