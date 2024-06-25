package com.furnycrew.furnidream.statistics.model.dao;

import com.furnycrew.furnidream.statistics.model.dto.OrderCountRankingDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderCountRankingMapper {
    List<OrderCountRankingDto> calculateOrderCountRankingByAllPeriod();
    List<OrderCountRankingDto> calculateOrderCountRankingByQuarterPeriod(Integer year, Integer quarter);
    List<OrderCountRankingDto> calculateOrderCountRankingByMonthPeriod(Integer year, Integer month);

    List<OrderCountRankingDto> calculateOrderCountRankingByCategoryAndAllPeriod(String category);
    List<OrderCountRankingDto> calculateOrderCountRankingByCategoryAndQuarterPeriod(String category, Integer year,
                                                                                    Integer quarter);
    List<OrderCountRankingDto> calculateOrderCountRankingByCategoryAndMonthPeriod(String category, Integer year,
                                                                                  Integer month);

}
