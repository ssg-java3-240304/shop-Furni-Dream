package com.furnycrew.furnidream.order.model.dao;

import com.furnycrew.furnidream.common.search.SearchCriteria;
import com.furnycrew.furnidream.order.model.dto.OrderDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@Mapper
public interface OrderMapper {
    public List<OrderDto> findOrdersByDateTime(SearchCriteria searchCriteria);
}
