package com.furnycrew.furnidream.salesmanagement.controller;


import com.furnycrew.furnidream.salesmanagement.model.dto.SalesMngDailyDto;
import com.furnycrew.furnidream.salesmanagement.model.dto.SalesMngMonthlyDto;
import com.furnycrew.furnidream.salesmanagement.model.service.SalesMngService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/salesStatistics")
@RequiredArgsConstructor
public class SalesMngController {
    private final SalesMngService salesMngService;

    @GetMapping("/totalSalesList")
    public void list(Model model) {
        log.info("GET /statistics/totalSalesList");
        List<SalesMngDailyDto> salesMngDailyDtos = salesMngService.findTotalSales();
        model.addAttribute("salesMngDailyDtoLists", salesMngDailyDtos);
    }

    @GetMapping("/totalMonthlySales")
    public void list2(Model model) {
        log.info("GET /statistics/totalMonthlySales");
        List<SalesMngMonthlyDto> salesMngMonthlyDtos = salesMngService.findMonthlySales();
        model.addAttribute("salesMonthlyDtoLists", salesMngMonthlyDtos);
    }



}
