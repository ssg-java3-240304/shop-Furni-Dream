package com.furnycrew.furnidream.salesmanagement.model.service;

import com.furnycrew.furnidream.salesmanagement.model.dao.SalesMngMapper;
import com.furnycrew.furnidream.salesmanagement.model.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class SalesMngService {
    private final SalesMngMapper salesMngMapper;

    // 전체 매출 조회
    public List<SalesMngDailyDto> findTotalSales(){
        return salesMngMapper.findTotalSales();
    }

    // 월별 매출 조회
    public List<SalesMngMonthlyDto> findMonthlySales(){
        return salesMngMapper.findMonthlySales();
    }

    // 분기별 매출 조회
    public List<SalesMngQuarterDto> findQuarterlySales(){
        return salesMngMapper.findQuarterlySales();
    }

    // 상품 당 연령층에 따른 매출 조회
    public List<SalesStatisticsByAgeDto> findSalesByAgeGroup(){
        return salesMngMapper.findSalesByAgeGroup();
    }


//    public List<SalsesStatisticsByGenderDto> findSalesByGender(){
//        return salesMngMapper.findSalesByGender();
//    }
}
