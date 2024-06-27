package com.furnycrew.furnidream.statistics.model.service;

import com.furnycrew.furnidream.statistics.model.dao.OrderSalesStatisticsMapper;
import com.furnycrew.furnidream.statistics.model.dao.OrderStatusStatisticsMapper;
import com.furnycrew.furnidream.statistics.model.dto.OrderSalesStatisticsDto;
import com.furnycrew.furnidream.statistics.model.dto.OrderStatusStatisticsDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderStatusStatisticsService {
    private final OrderStatusStatisticsMapper orderStatusStatisticsMapper;

    public List<OrderStatusStatisticsDto> findAllOrderStatus(){
        return orderStatusStatisticsMapper.findAllOrderStatus();
    }
}
