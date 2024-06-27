package com.furnycrew.furnidream.salesmanagement.model.dao;

import com.furnycrew.furnidream.salesmanagement.model.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SalesMngMapper {
    // 전체 매출 조회
    List<SalesMngDailyDto> findTotalSales(@Param("offset") int offset, @Param("limit") int limit);

    // 월별 매출 조회
    List<SalesMngMonthlyDto> findMonthlySales();

    // 분기별 매출 조회
    List<SalesMngQuarterDto> findQuarterlySales();

    // 상품 당 연령층에 따른 매출 조회
    List<SalesStatisticsByAgeDto> findSalesByAgeGroup(@Param("offset") int offset, @Param("limit") int limit);

    List<SalesStatisticsByAgeDto> findSalesByAgeGroupAndTotalSales();

    //  상품 당 매출 조회
    List<SalesStatisticsByProductDto> findSalesByProduct(@Param("offset") int offset, @Param("limit") int limit);

    int count();
}
