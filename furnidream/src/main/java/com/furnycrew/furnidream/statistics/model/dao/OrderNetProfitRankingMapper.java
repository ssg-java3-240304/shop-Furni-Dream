package com.furnycrew.furnidream.statistics.model.dao;

import com.furnycrew.furnidream.statistics.model.dto.OrderNetProfitRankingDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderNetProfitRankingMapper {
    List<OrderNetProfitRankingDto> calculateOrderNetProfitRankingByAllPeriod();
    List<OrderNetProfitRankingDto> calculateOrderNetProfitRankingByQuarterPeriod(int year, int quarter);
    List<OrderNetProfitRankingDto> calculateOrderNetProfitRankingByMonthPeriod(int year, int month);

}
