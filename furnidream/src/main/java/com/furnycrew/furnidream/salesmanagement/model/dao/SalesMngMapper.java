package com.furnycrew.furnidream.salesmanagement.model.dao;

import com.furnycrew.furnidream.salesmanagement.model.dto.SalesMngDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SalesMngMapper {
    // 전체 매출 조회
    List<SalesMngDto> findTotalSales();

    // 월별 매출 조회
    List<SalesMngDto> findMonthlySales();

    // 분기별 매출 조회
    List<SalesMngDto> findQuarterlySales();

    // 상품 당 연령층에 따른 매출 조회
//    SalesMngDto findSalesByAgeGroup();

    // 상품 당 성비에 따른 매출 조회
//    ProductSalesDto findSalesByGender();

}
