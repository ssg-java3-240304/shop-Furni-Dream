package com.furnycrew.furnidream.statistics.model.service;

import com.furnycrew.furnidream.statistics.model.dao.OrderCountRankingMapper;
import com.furnycrew.furnidream.statistics.model.dto.OrderCountRankingDto;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderCountRankingService {
    private final OrderCountRankingMapper orderCountRankingMapper;

    public List<OrderCountRankingDto> calculateOrderCountRankingByAllPeriod() {
        return orderCountRankingMapper.calculateOrderCountRankingByAllPeriod();
    }

    public List<OrderCountRankingDto> calculateOrderCountRankingByQuarterPeriod(Integer year, Integer quarter) {
        return orderCountRankingMapper.calculateOrderCountRankingByQuarterPeriod(year, quarter);
    }

    public List<OrderCountRankingDto> calculateOrderCountRankingByMonthPeriod(Integer year, Integer month) {
        return orderCountRankingMapper.calculateOrderCountRankingByMonthPeriod(year, month);
    }

    public List<OrderCountRankingDto> calculateOrderCountRankingByCategoryAndAllPeriod(String category) {
        return orderCountRankingMapper.calculateOrderCountRankingByCategoryAndAllPeriod(category);
    }

    public List<OrderCountRankingDto> calculateOrderCountRankingByCategoryAndQuarterPeriod(String category, Integer year,
                                                                                           Integer quarter) {
        return orderCountRankingMapper.calculateOrderCountRankingByCategoryAndQuarterPeriod(category, year, quarter);
    }

    public List<OrderCountRankingDto> calculateOrderCountRankingByCategoryAndMonthPeriod(String category, Integer year,
                                                                                         Integer month) {
        return orderCountRankingMapper.calculateOrderCountRankingByCategoryAndMonthPeriod(category, year, month);
    }

}
