package com.furnycrew.furnidream.statistics.model.dao;

import static org.assertj.core.api.Assertions.assertThat;

import com.furnycrew.furnidream.statistics.model.dto.OrderCountRankingDto;
import com.furnycrew.furnidream.statistics.model.dto.OrderNetProfitRankingDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
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

        List<OrderNetProfitRankingDto> sortedResult = new ArrayList<>(result);
        Collections.sort(sortedResult, (o1, o2) -> o2.getNetProfit() - o1.getNetProfit());

        // then
        assertThat(result).isNotNull().isEqualTo(sortedResult);
//        for (OrderCountRankingDto orderCountRankingDto : result) {
//            System.out.println(orderCountRankingDto);
//        }
    }

    @DisplayName("[분기별/전체] 상품별 순수익 내림차순 정렬로 가져오기")
    @ParameterizedTest
    @CsvSource(value = {"2023,4", "2024,1", "2024,2"})
    void calculateOrderNetProfitRankingByQuarterPeriod(int year, int quarter) {
        // given
        // when
        List<OrderNetProfitRankingDto> result
                = orderNetProfitRankingMapper.calculateOrderNetProfitRankingByQuarterPeriod(year, quarter);

        List<OrderNetProfitRankingDto> sortedResult = new ArrayList<>(result);
        Collections.sort(sortedResult, (o1, o2) -> o2.getNetProfit() - o1.getNetProfit());

        // then
        assertThat(result).isNotNull().isEqualTo(sortedResult);
    }

    @DisplayName("[분기별/전체] 잘못된 기간의 상품별 순수익 내림차순 정렬로 가져오기")
    @ParameterizedTest
    @CsvSource(value = {"2025,1", "2025,2", "2026,1"})
    void calculateOrderNetProfitRankingByQuarterPeriodAndNotPeriod(int year, int quarter) {
        // given
        // when
        List<OrderNetProfitRankingDto> result
                = orderNetProfitRankingMapper.calculateOrderNetProfitRankingByQuarterPeriod(year, quarter);

        // then
        assertThat(result).isEmpty();
    }

    @DisplayName("[월별/전체] 상품별 순수익 내림차순 정렬로 가져오기")
    @ParameterizedTest
    @CsvSource(value = {"2023,4", "2024,1", "2024,2"})
    void calculateOrderNetProfitRankingByMonthPeriod(int year, int month) {
        // given
        // when
        List<OrderNetProfitRankingDto> result
                = orderNetProfitRankingMapper.calculateOrderNetProfitRankingByMonthPeriod(year, month);

        List<OrderNetProfitRankingDto> sortedResult = new ArrayList<>(result);
        Collections.sort(sortedResult, (o1, o2) -> o2.getNetProfit() - o1.getNetProfit());

        // then
        assertThat(result).isNotNull().isEqualTo(sortedResult);
    }

    @DisplayName("[월별/전체] 잘못된 기간의 상품별 순수익 내림차순 정렬로 가져오기")
    @ParameterizedTest
    @CsvSource(value = {"2025,1", "2025,2", "2026,1"})
    void calculateOrderNetProfitRankingByMonthPeriodAndNotPeriod(int year, int month) {
        // given
        // when
        List<OrderNetProfitRankingDto> result
                = orderNetProfitRankingMapper.calculateOrderNetProfitRankingByMonthPeriod(year, month);

        // then
        assertThat(result).isEmpty();
    }

    @DisplayName("[모든기간/카테고리] 상품별 순수익 내림차순 정렬로 가져오기")
    @ParameterizedTest
    @ValueSource(strings = {"소파", "침대","의자"})
    void calculateOrderNetProfitRankingByCategoryAndAllPeriod(String category) {
        // given
        // when
        List<OrderNetProfitRankingDto> result
                = orderNetProfitRankingMapper.calculateOrderNetProfitRankingByCategoryAndAllPeriod(category);

        List<OrderNetProfitRankingDto> sortedResult = new ArrayList<>(result);
        Collections.sort(sortedResult, (o1, o2) -> o2.getNetProfit() - o1.getNetProfit());

        // then
        assertThat(result).isNotNull().isEqualTo(sortedResult);
        assertThat(result).extracting(OrderNetProfitRankingDto::getCategory).containsOnly(category);
    }

    @DisplayName("[분기별/카테고리] 상품별 순수익 내림차순 정렬로 가져오기")
    @ParameterizedTest
    @CsvSource(value= {"소파, 2023, 4", "침대, 2024, 1","의자, 2024, 2"})
    void calculateOrderNetProfitRankingByCategoryAndQuarterPeriod(String category, int year, int quarter) {
        // given
        // when
        List<OrderNetProfitRankingDto> result
                = orderNetProfitRankingMapper.calculateOrderNetProfitRankingByCategoryAndQuarterPeriod(category, year, quarter);

        List<OrderNetProfitRankingDto> sortedResult = new ArrayList<>(result);
        Collections.sort(sortedResult, (o1, o2) -> o2.getNetProfit() - o1.getNetProfit());

        // then
        assertThat(result).isNotNull().isEqualTo(sortedResult);
        assertThat(result).extracting(OrderNetProfitRankingDto::getCategory).containsOnly(category);
    }
}
