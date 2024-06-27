package com.furnycrew.furnidream.statistics.model.dao;

import static org.assertj.core.api.Assertions.assertThat;

import com.furnycrew.furnidream.statistics.model.dto.OrderSalesStatisticsDto;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderSalesStatisticsMapperTest {
    @Autowired
    private OrderSalesStatisticsMapper orderSalesStatisticsMapper;

    @DisplayName("연도별 월 매출액 가져오기")
    @Test
    void calculateSalesStatistics() {
        List<OrderSalesStatisticsDto> result = orderSalesStatisticsMapper.calculateSalesStatistics(
                2024);

        assertThat(result.size()).isNotNull().isEqualTo(6);
//        for (OrderSalesStatisticsDto orderSalesStatisticsDto : result) {
//            System.out.println(orderSalesStatisticsDto);
//        }
    }
}