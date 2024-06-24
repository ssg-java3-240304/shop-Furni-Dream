package com.furnycrew.furnidream.statistics.model.service;

import com.furnycrew.furnidream.statistics.model.dao.StatisticsMapper;
import com.furnycrew.furnidream.statistics.model.dto.OrderCountRankingDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatisticsService {
    private final StatisticsMapper statisticsMapper;

    public List<OrderCountRankingDto> calculateOrderCountRankByAllPeriod() {
        return statisticsMapper.calculateOrderCountRankByAllPeriod();
    }

    public List<OrderCountRankingDto> calculateOrderCountRankByQuarterPeriod(int year, int period) {
        return statisticsMapper.calculateOrderCountRankByQuarterPeriod(year, period);
    }

    public List<OrderCountRankingDto> calculateOrderCountRankByMonthPeriod(int year, int month) {
        return statisticsMapper.calculateOrderCountRankByMonthPeriod(year, month);
    }
}
