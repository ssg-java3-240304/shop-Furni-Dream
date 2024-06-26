package com.furnycrew.furnidream.statistics.model.service;

import com.furnycrew.furnidream.statistics.model.dao.OrderSalesStatisticsMapper;
import com.furnycrew.furnidream.statistics.model.dto.OrderSalesStatisticsDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderSalesStatisticsService {
    private final OrderSalesStatisticsMapper orderSalesStatisticsMapper;

    public List<OrderSalesStatisticsDto> calculateSalesStatistics(Integer year){
        return orderSalesStatisticsMapper.calculateSalesStatistics(year);
    }
}
