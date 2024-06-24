package com.furnycrew.furnidream.statistics.model.dao;

import com.furnycrew.furnidream.statistics.model.dto.OrderCountRankingDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StatisticsMapper {

    List<OrderCountRankingDto> calculateOrderCountRankByAllPeriod();
    List<OrderCountRankingDto> calculateOrderCountRankByQuarterPeriod(int year, int quarter);
    List<OrderCountRankingDto> calculateOrderCountRankByMonthPeriod(int year, int month);
}
