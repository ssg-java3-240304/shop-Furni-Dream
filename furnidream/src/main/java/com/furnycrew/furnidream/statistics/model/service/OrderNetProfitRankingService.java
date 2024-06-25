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
}
