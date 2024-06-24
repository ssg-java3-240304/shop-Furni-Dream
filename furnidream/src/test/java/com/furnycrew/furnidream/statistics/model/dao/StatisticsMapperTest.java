package com.furnycrew.furnidream.statistics.model.dao;

import static org.assertj.core.api.Assertions.assertThat;

import com.furnycrew.furnidream.statistics.model.dto.OrderCountRankingDto;
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
class StatisticsMapperTest {

    @Autowired
    private StatisticsMapper menuMapper;

    @DisplayName("[모든 기간/전체] 상품별 주문량 내림차순 정렬로 가져오기")
    @Test
    void calculateOrderCountRankByAllPeriod() {
        // given
        // when
        List<OrderCountRankingDto> result = menuMapper.calculateOrderCountRankByAllPeriod();

        List<OrderCountRankingDto> sortedResult = new ArrayList<>(result);
        Collections.sort(sortedResult, (o1, o2) -> o2.getQuantity() - o1.getQuantity());

        // then
        assertThat(result).isNotNull().isEqualTo(sortedResult);
//        for (OrderCountRankingDto orderCountRankingDto : result) {
//            System.out.println(orderCountRankingDto);
//        }
    }

    @DisplayName("[분기별/전체] 상품별 주문량 내림차순 정렬로 가져오기")
    @Test
    void calculateOrderCountRankByQuarterPeriod() {
        // given
        // when
        List<OrderCountRankingDto> result = menuMapper.calculateOrderCountRankByQuarterPeriod(2024, 2);

        List<OrderCountRankingDto> sortedResult = new ArrayList<>(result);
        Collections.sort(sortedResult, (o1, o2) -> o2.getQuantity() - o1.getQuantity());

        // then
        assertThat(result).isNotNull().isEqualTo(sortedResult);
    }

    @DisplayName("[월별/전체] 상품별 주문량 내림차순 정렬로 가져오기")
    @Test
    void calculateOrderCountRankByMonthPeriod() {
        // given
        // when
        List<OrderCountRankingDto> result = menuMapper.calculateOrderCountRankByMonthPeriod(2024, 4);

        List<OrderCountRankingDto> sortedResult = new ArrayList<>(result);
        Collections.sort(sortedResult, (o1, o2) -> o2.getQuantity() - o1.getQuantity());

        // then
        assertThat(result).isNotNull().isEqualTo(sortedResult);
    }

    @DisplayName("[모든 기간/카테고리] 상품별 주문량 내림차순 정렬로 가져오기")
    @ParameterizedTest()
    @ValueSource(strings = {"소파", "침대", "책상"})
    void calculateOrderCountRankByCategoryAndAllPeriod(String category) {
        // given
        // when
        List<OrderCountRankingDto> result = menuMapper.calculateOrderCountRankByCategoryAndAllPeriod(category);

        List<OrderCountRankingDto> sortedResult = new ArrayList<>(result);
        Collections.sort(sortedResult, (o1, o2) -> o2.getQuantity() - o1.getQuantity());

        // then
        assertThat(result).isNotNull().isEqualTo(sortedResult);
        assertThat(result).extracting(OrderCountRankingDto::getCategory).containsOnly(category);
    }

    @DisplayName("[분기별/카테고리] 상품별 주문량 내림차순 정렬로 가져오기")
    @ParameterizedTest()
    @CsvSource(value = {"소파, 2024, 2", "침대, 2024, 2", "책상, 2024, 2"})
    void calculateOrderCountRankByCategoryAndQuarterPeriod(String category, int year, int quarter) {
        // given
        // when
        List<OrderCountRankingDto> result = menuMapper.calculateOrderCountRankByCategoryAndQuarterPeriod(category, year,
                quarter);

        List<OrderCountRankingDto> sortedResult = new ArrayList<>(result);
        Collections.sort(sortedResult, (o1, o2) -> o2.getQuantity() - o1.getQuantity());

        // then
        assertThat(result).isNotNull().isEqualTo(sortedResult);
        assertThat(result).extracting(OrderCountRankingDto::getCategory).containsOnly(category);
    }

    @DisplayName("[월별/카테고리] 상품별 주문량 내림차순 정렬로 가져오기")
    @ParameterizedTest()
    @CsvSource(value = {"소파, 2024, 4", "침대, 2024, 4", "책상, 2024, 4"})
    void calculateOrderCountRankByCategoryAndMonthPeriod(String category, int year, int month) {
        // given
        // when
        List<OrderCountRankingDto> result = menuMapper.calculateOrderCountRankByCategoryAndMonthPeriod(category, year,
                month);

        List<OrderCountRankingDto> sortedResult = new ArrayList<>(result);
        Collections.sort(sortedResult, (o1, o2) -> o2.getQuantity() - o1.getQuantity());

        // then
        assertThat(result).isNotNull().isEqualTo(sortedResult);
        assertThat(result).extracting(OrderCountRankingDto::getCategory).containsOnly(category);
    }
}