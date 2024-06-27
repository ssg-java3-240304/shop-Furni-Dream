package com.furnycrew.furnidream.statistics.model.dao;

import com.furnycrew.furnidream.statistics.model.dto.OrderSalesStatisticsDto;
import com.furnycrew.furnidream.statistics.model.dto.OrderStatusStatisticsDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderStatusStatisticsMapper {
   List<OrderStatusStatisticsDto> findAllOrderStatus();

}
