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

    public List<OrderCountRankingDto> calculateOrderCountRank(){
        return statisticsMapper.calculateOrderCountRank();
    }

}
