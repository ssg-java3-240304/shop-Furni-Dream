package com.furnycrew.furnidream.salesmanagement.model.dao;


import com.furnycrew.furnidream.salesmanagement.model.dto.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.assertj.core.api.InstanceOfAssertFactories.list;

@SpringBootTest
class SalesMngMapperTest {
    @Autowired
    private SalesMngMapper salesMngMapper;

    @Test
    @DisplayName("전체 매출 조회")
    void findTotalSales() {
        // given
        int offset = 1;
        int limit = 10;

        // when
        List<SalesMngDailyDto> salesMngDailyDtos = salesMngMapper.findTotalSales(offset, limit);
        System.out.println(salesMngDailyDtos);

        // then
        assertThat(salesMngDailyDtos)
                .isNotNull()
                .isNotEmpty();

    }

    @Test
    @DisplayName("월별 매출 조회")
    void findMonthlySales() {
        // given
        // when
        List<SalesMngMonthlyDto> salesMngDtos = salesMngMapper.findMonthlySales();
        System.out.println(salesMngDtos);

        // then
        assertThat(salesMngDtos)
                .isNotNull()
                .isNotEmpty();
    }

    @Test
    @DisplayName("분기별 매출 조회")
    void findQuarterlySales() {
        // given

        // when
        List<SalesMngQuarterDto> salesMngQuarterDtos = salesMngMapper.findQuarterlySales();
        System.out.println(salesMngQuarterDtos);

        // then
        assertThat(salesMngQuarterDtos)
                .isNotNull()
                .isNotEmpty();
    }

    @Test
    @DisplayName("상품별 연령층에 따른 매출 조회")
    void findSalesByAgeGroup() {
        // given
        int offset = 1;
        int limit = 10;

        // when
        List<SalesStatisticsByAgeDto> salesStatisticsByAgeDtos = salesMngMapper.findSalesByAgeGroup(offset, limit);
        System.out.println(salesStatisticsByAgeDtos);

        // then
        assertThat(salesStatisticsByAgeDtos)
                .isNotNull()
                .isNotEmpty();
    }

    @Test
    @DisplayName("상품별 매출 조회")
    void testFindSalesByGender() {
        //given
        int offset = 1;
        int limit = 10;

        //when
        List<SalesStatisticsByProductDto> salesStatisticsByProductDtos = salesMngMapper.findSalesByProduct(offset, limit);
        System.out.println(salesStatisticsByProductDtos);

        //then
        assertThat(salesStatisticsByProductDtos)
                .isNotNull()
                .isNotEmpty();
    }
}