package com.furnycrew.furnidream.salesmanagement.controller;

import com.furnycrew.furnidream.common.paging.PageCriteria;
import com.furnycrew.furnidream.salesmanagement.model.dto.*;
import com.furnycrew.furnidream.salesmanagement.model.service.SalesMngService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/salesStatistics")
@RequiredArgsConstructor
public class SalesMngController {
    private final SalesMngService salesMngService;

    @GetMapping("/totalSalesList")
    public void list(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int limit,
            Model model) {
        log.info("GET /statistics/totalSalesList?page={}&limit={}", page, limit);

        // 1. 컨텐츠 영역 (limit쿼리)
        int offset = (page - 1) * limit; // 1페이지 - 0, 2페이지 - 10, 3페이지 - 20, ...
        List<SalesMngDailyDto> salesMngDailyDtos = salesMngService.findTotalSales(offset, limit);
        log.debug("statistics = {}", salesMngDailyDtos);
        model.addAttribute("statistics", salesMngDailyDtos);

        // 2. 페이지 바 영역  (html)
        int totalCount = salesMngService.count();
        String url = "totalSalesList";
        model.addAttribute("pageCriteria", new PageCriteria(page, limit, totalCount, url));

    }

    @GetMapping("/totalSalesByProduct")
    public void list5(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int limit,
            Model model) {
        log.info("GEt / statistics/totalSalesByProduct?page={}&limit={}", page, limit);

        //1. 컨텐츠 영역 (limit 쿼리)
        int offset = (page - 1) * limit;
        List<SalesStatisticsByProductDto> salesStatisticsByProductDtos = salesMngService.findSalesByProduct(offset, limit);
        model.addAttribute("salesByProduct", salesStatisticsByProductDtos);

        // 2. 페이지 바
        int totalCount = salesMngService.count();
        String url = "totalSalesByProduct";
        model.addAttribute("pageCriteria", new PageCriteria(page, limit, totalCount, url));
    }

    @GetMapping("/salesByAge")
    public void list4(@RequestParam(defaultValue = "1") int page,
                      @RequestParam(defaultValue = "20") int limit,
                      Model model) {
        log.info("GEt / statistics/salesByAge??page={}&limit={}", page, limit);

        //1. 컨텐츠
        int offset = (page - 1) * limit;
        List<SalesStatisticsByAgeDto> salesStatisticsByAgeDtos = salesMngService.findSalesByAgeGroup(offset, limit);
        model.addAttribute("salesByAge", salesStatisticsByAgeDtos);

        //2. 페이지 바
        int totalCount = salesMngService.count();
        String url = "salesByAge";
        model.addAttribute("pageCriteria", new PageCriteria(page, limit, totalCount, url));
    }

    @GetMapping("/totalMonthlySales")
    public void list2(Model model) {
        log.info("GET /statistics/totalMonthlySales");
        List<SalesMngMonthlyDto> salesMngMonthlyDtos = salesMngService.findMonthlySales();
        model.addAttribute("salesMonthlyDtoLists", salesMngMonthlyDtos);
    }

    @GetMapping("/totalQuarterSales")
    public void list3(Model model) {
        log.info("GET /statistics/totalQuarterSales");
        List<SalesMngQuarterDto> salesMngQuarterDtos = salesMngService.findQuarterlySales();
        model.addAttribute("salesMngQuarterDtoLists", salesMngQuarterDtos);
    }




}
