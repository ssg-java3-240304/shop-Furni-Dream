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

    public List<OrderNetProfitRankingDto> calculateOrderNetProfitRankingByQuarterPeriod(int year, int quarter) {
        return orderNetProfitRankingMapper.calculateOrderNetProfitRankingByQuarterPeriod(year, quarter);
    }

    public List<OrderNetProfitRankingDto> calculateOrderNetProfitRankingByMonthPeriod(int year, int month) {
        return orderNetProfitRankingMapper.calculateOrderNetProfitRankingByMonthPeriod(year, month);
    }

    public List<OrderNetProfitRankingDto> calculateOrderNetProfitRankingByCategoryAndAllPeriod(String category) {
        return orderNetProfitRankingMapper.calculateOrderNetProfitRankingByCategoryAndAllPeriod(category);
    }

    public List<OrderNetProfitRankingDto> calculateOrderNetProfitRankingByCategoryAndQuarterPeriod(String category, int year, int quarter) {
        return orderNetProfitRankingMapper.calculateOrderNetProfitRankingByCategoryAndQuarterPeriod(category, year, quarter);
    }

    public List<OrderNetProfitRankingDto> calculateOrderNetProfitRankingByCategoryAndMonthPeriod(String category, int year, int month) {
        return orderNetProfitRankingMapper.calculateOrderNetProfitRankingByCategoryAndMonthPeriod(category, year, month);
    }


}
