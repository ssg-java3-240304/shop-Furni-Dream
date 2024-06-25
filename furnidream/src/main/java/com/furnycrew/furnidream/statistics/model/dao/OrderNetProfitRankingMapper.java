package com.furnycrew.furnidream.statistics.model.dao;

import com.furnycrew.furnidream.statistics.model.dto.OrderNetProfitRankingDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderNetProfitRankingMapper {
    List<OrderNetProfitRankingDto> calculateOrderNetProfitRankingByAllPeriod();
    List<OrderNetProfitRankingDto> calculateOrderNetProfitRankingByQuarterPeriod(Integer year, Integer quarter);
    List<OrderNetProfitRankingDto> calculateOrderNetProfitRankingByMonthPeriod(Integer year, Integer month);

    List<OrderNetProfitRankingDto> calculateOrderNetProfitRankingByCategoryAndAllPeriod(String category);
    List<OrderNetProfitRankingDto> calculateOrderNetProfitRankingByCategoryAndQuarterPeriod(String category, Integer year, Integer quarter);
    List<OrderNetProfitRankingDto> calculateOrderNetProfitRankingByCategoryAndMonthPeriod(String category, Integer year, Integer month);


}
