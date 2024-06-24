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
class OrderCountRankingMapperTest {

    @Autowired
    private OrderCountRankingMapper orderCountRankingMapper;

    @DisplayName("[모든 기간/전체] 상품별 주문량 내림차순 정렬로 가져오기")
    @Test
    void calculateOrderCountRankingByAllPeriod() {
        // given
        // when
        List<OrderCountRankingDto> result = orderCountRankingMapper.calculateOrderCountRankingByAllPeriod();

        List<OrderCountRankingDto> sortedResult = new ArrayList<>(result);
        Collections.sort(sortedResult, (o1, o2) -> o2.getQuantity() - o1.getQuantity());

        // then
        assertThat(result).isNotNull().isEqualTo(sortedResult);
//        for (OrderCountRankingDto orderCountRankingDto : result) {
//            System.out.println(orderCountRankingDto);
//        }
    }

    @DisplayName("[분기별/전체] 상품별 주문량 내림차순 정렬로 가져오기")
    @ParameterizedTest
    @CsvSource(value = {"2024,2","2024,1", "2023,4"})
    void calculateOrderCountRankingByQuarterPeriod(int year, int quarter) {
        // given
        // when
        List<OrderCountRankingDto> result = orderCountRankingMapper.calculateOrderCountRankingByQuarterPeriod(year, quarter);

        List<OrderCountRankingDto> sortedResult = new ArrayList<>(result);
        Collections.sort(sortedResult, (o1, o2) -> o2.getQuantity() - o1.getQuantity());

        // then
        assertThat(result).isNotNull().isEqualTo(sortedResult);
    }

    @DisplayName("[분기별/전체] 기간을 벗어난 상품별 주문량 내림차순 정렬로 가져오기 ")
    @ParameterizedTest
    @CsvSource(value = {"2025,1","2025,2", "2026,1"})
    void calculateOrderCountRankingByQuarterPeriodAndNotPeriod(int year, int quarter) {
        // given
        // when
        List<OrderCountRankingDto> result = orderCountRankingMapper.calculateOrderCountRankingByQuarterPeriod(year, quarter);

        // then
        assertThat(result).isEmpty();
    }

    @DisplayName("[월별/전체] 상품별 주문량 내림차순 정렬로 가져오기")
    @ParameterizedTest
    @CsvSource(value = {"2024,4","2024,3", "2024,2"})
    void calculateOrderCountRankingByMonthPeriod(int year, int month) {
        // given
        // when
        List<OrderCountRankingDto> result = orderCountRankingMapper.calculateOrderCountRankingByMonthPeriod(year, month);

        List<OrderCountRankingDto> sortedResult = new ArrayList<>(result);
        Collections.sort(sortedResult, (o1, o2) -> o2.getQuantity() - o1.getQuantity());

        // then
        assertThat(result).isNotNull().isEqualTo(sortedResult);
    }

    @DisplayName("[월별/전체] 기간을 벗어난 상품별 주문량 내림차순 정렬로 가져오기")
    @ParameterizedTest
    @CsvSource(value = {"2025,1","2025,6", "2026,9"})
    void calculateOrderCountRankingByMonthPeriodAndNotPeriod(int year, int month) {
        // given
        // when
        List<OrderCountRankingDto> result = orderCountRankingMapper.calculateOrderCountRankingByMonthPeriod(year, month);


        // then
        assertThat(result).isEmpty();
    }

    @DisplayName("[모든 기간/카테고리] 상품별 주문량 내림차순 정렬로 가져오기")
    @ParameterizedTest()
    @ValueSource(strings = {"소파", "침대", "책상"})
    void calculateOrderCountRankingByCategoryAndAllPeriod(String category) {
        // given
        // when
        List<OrderCountRankingDto> result = orderCountRankingMapper.calculateOrderCountRankingByCategoryAndAllPeriod(category);

        List<OrderCountRankingDto> sortedResult = new ArrayList<>(result);
        Collections.sort(sortedResult, (o1, o2) -> o2.getQuantity() - o1.getQuantity());

        // then
        assertThat(result).isNotNull().isEqualTo(sortedResult);
        assertThat(result).extracting(OrderCountRankingDto::getCategory).containsOnly(category);
    }

    @DisplayName("[분기별/카테고리] 상품별 주문량 내림차순 정렬로 가져오기")
    @ParameterizedTest()
    @CsvSource(value = {"소파, 2024, 2", "침대, 2024, 2", "책상, 2024, 2"})
    void calculateOrderCountRankingByCategoryAndQuarterPeriod(String category, int year, int quarter) {
        // given
        // when
        List<OrderCountRankingDto> result = orderCountRankingMapper.calculateOrderCountRankingByCategoryAndQuarterPeriod(category, year,
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
    void calculateOrderCountRankingByCategoryAndMonthPeriod(String category, int year, int month) {
        // given
        // when
        List<OrderCountRankingDto> result = orderCountRankingMapper.calculateOrderCountRankingByCategoryAndMonthPeriod(category, year,
                month);

        List<OrderCountRankingDto> sortedResult = new ArrayList<>(result);
        Collections.sort(sortedResult, (o1, o2) -> o2.getQuantity() - o1.getQuantity());

        // then
        assertThat(result).isNotNull().isEqualTo(sortedResult);
        assertThat(result).extracting(OrderCountRankingDto::getCategory).containsOnly(category);
    }
}