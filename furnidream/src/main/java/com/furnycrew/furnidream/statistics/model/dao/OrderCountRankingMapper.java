package com.furnycrew.furnidream.statistics.model.dao;

import com.furnycrew.furnidream.statistics.model.dto.OrderCountRankingDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderCountRankingMapper {
    List<OrderCountRankingDto> calculateOrderCountRankingByAllPeriod();
    List<OrderCountRankingDto> calculateOrderCountRankingByQuarterPeriod(int year, int quarter);
    List<OrderCountRankingDto> calculateOrderCountRankingByMonthPeriod(int year, int month);

    List<OrderCountRankingDto> calculateOrderCountRankingByCategoryAndAllPeriod(String category);
    List<OrderCountRankingDto> calculateOrderCountRankingByCategoryAndQuarterPeriod(String category, int year,
                                                                                    int quarter);
    List<OrderCountRankingDto> calculateOrderCountRankingByCategoryAndMonthPeriod(String category, int year,
                                                                                  int month);

}
