package com.furnycrew.furnidream.statistics.model.service;

import com.furnycrew.furnidream.statistics.model.dao.OrderNetProfitRankingMapper;
import com.furnycrew.furnidream.statistics.model.dto.OrderNetProfitRankingDto;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderNetProfitRankingService {
    private final OrderNetProfitRankingMapper orderNetProfitRankingMapper;

    public List<OrderNetProfitRankingDto> calculateOrderNetProfitRankingByAllPeriod() {
        return orderNetProfitRankingMapper.calculateOrderNetProfitRankingByAllPeriod();
    }

    public List<OrderNetProfitRankingDto> calculateOrderNetProfitRankingByQuarterPeriod(Integer year, Integer quarter) {
        return orderNetProfitRankingMapper.calculateOrderNetProfitRankingByQuarterPeriod(year, quarter);
    }

    public List<OrderNetProfitRankingDto> calculateOrderNetProfitRankingByMonthPeriod(Integer year, Integer month) {
        return orderNetProfitRankingMapper.calculateOrderNetProfitRankingByMonthPeriod(year, month);
    }

    public List<OrderNetProfitRankingDto> calculateOrderNetProfitRankingByCategoryAndAllPeriod(String category) {
        return orderNetProfitRankingMapper.calculateOrderNetProfitRankingByCategoryAndAllPeriod(category);
    }

    public List<OrderNetProfitRankingDto> calculateOrderNetProfitRankingByCategoryAndQuarterPeriod(String category, Integer year, Integer quarter) {
        return orderNetProfitRankingMapper.calculateOrderNetProfitRankingByCategoryAndQuarterPeriod(category, year, quarter);
    }

    public List<OrderNetProfitRankingDto> calculateOrderNetProfitRankingByCategoryAndMonthPeriod(String category, Integer year, Integer month) {
        return orderNetProfitRankingMapper.calculateOrderNetProfitRankingByCategoryAndMonthPeriod(category, year, month);
    }


}
