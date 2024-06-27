package com.furnycrew.furnidream.statistics.model.dao;

import com.furnycrew.furnidream.statistics.model.dto.OrderSalesStatisticsDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderSalesStatisticsMapper {
    List<OrderSalesStatisticsDto> calculateSalesStatistics(Integer year);

}
