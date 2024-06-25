package com.furnycrew.furnidream.salesmanagement.model.dao;


import com.furnycrew.furnidream.salesmanagement.model.dto.SalesMngDailyDto;
import com.furnycrew.furnidream.salesmanagement.model.dto.SalesMngMonthlyDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SalesMngMapperTest {
    @Autowired
    private SalesMngMapper salesMngMapper;

    @Test
    @DisplayName("전체 매출 조회")
    void findTotalSales() {
        // given
        // when
        List<SalesMngDailyDto> salesMngDailyDtos = salesMngMapper.findTotalSales();
//        System.out.println(salesMngDailyDtos);

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

        // then
    }

    @Test
    @DisplayName("상품별 연령층에 따른 매출 조회")
    void findSalesByAgeGroup() {
        // given
        // when
        // then
    }

    @Test
    @DisplayName("상품별 성비에 따른 매출 조회")
    void findSalesByGender() {
        // given
        // when
        // then
    }
}