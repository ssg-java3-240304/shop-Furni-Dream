package com.furnycrew.furnidream.statistics.model.dao;

import static org.assertj.core.api.Assertions.assertThat;

import com.furnycrew.furnidream.statistics.model.dto.OrderCountRankingDto;
import com.furnycrew.furnidream.statistics.model.dto.OrderNetProfitRankingDto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderNetProfitRankingMapperTest {

    @Autowired
    private OrderNetProfitRankingMapper orderNetProfitRankingMapper;

    @DisplayName("[모든 기간/전체] 상품별 순수익 내림차순 정렬로 가져오기")
    @Test
    void calculateOrderNetProfitRankingByAllPeriod() {
        // given
        // when
        List<OrderNetProfitRankingDto> result = orderNetProfitRankingMapper.calculateOrderNetProfitRankingByAllPeriod();

        List<OrderNetProfitRankingDto>  sortedResult = new ArrayList<>(result);
        Collections.sort(sortedResult, (o1, o2) -> o2.getNetProfit() - o1.getNetProfit());

        // then
        assertThat(result).isNotNull().isEqualTo(sortedResult);
//        for (OrderCountRankingDto orderCountRankingDto : result) {
//            System.out.println(orderCountRankingDto);
//        }
    }

}
