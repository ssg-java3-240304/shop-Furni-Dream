package com.furnycrew.furnidream.statistics.controller;

import com.furnycrew.furnidream.statistics.model.dto.OrderCountRankingDto;
import com.furnycrew.furnidream.statistics.model.dto.OrderNetProfitRankingDto;
import com.furnycrew.furnidream.statistics.model.service.OrderCountRankingService;
import com.furnycrew.furnidream.statistics.model.service.OrderNetProfitRankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/statistics/order/net-profit-ranking")
public class OrderNetProfitRankingController {
    private final OrderNetProfitRankingService orderNetProfitRankingService;

    @GetMapping({"/all", "/category"})
    public String orderCountRankingMain() {
        return "statistics/order/net-profit/main";
    }

    @GetMapping("/all/{period}")
    public String calculateOrderNetProfitRankingByAll(@PathVariable String period, Integer year, Integer quarter, Integer month, Model model) {
        List<OrderNetProfitRankingDto> orderNetProfitRankingList =null;

        if ("all-period".equals(period)) {
            orderNetProfitRankingList = orderNetProfitRankingService.calculateOrderNetProfitRankingByAllPeriod();
        } else if ("quarter-period".equals(period)) {
            orderNetProfitRankingList = orderNetProfitRankingService.calculateOrderNetProfitRankingByQuarterPeriod(year, quarter);
        } else if ("month-period".equals(period)) {
            orderNetProfitRankingList = orderNetProfitRankingService.calculateOrderNetProfitRankingByMonthPeriod(year, month);

        } else {
            //오류처리
        }

        model.addAttribute("orderNetProfitRankingList", orderNetProfitRankingList);
        model.addAttribute("period", period); // period 정보를 모델에 추가

        return "statistics/order/net-profit/ranking";
    }

    @GetMapping("/category/{period}")
    public String calculateOrderNetProfitRankingByCategory(@PathVariable String period, String category, Integer year,
                                                           Integer quarter, Integer month, Model model) {
        List<OrderNetProfitRankingDto> orderNetProfitRankingList =null;


        if ("all-period".equals(period)) {
            orderNetProfitRankingList = orderNetProfitRankingService.calculateOrderNetProfitRankingByCategoryAndAllPeriod(category);
        } else if ("quarter-period".equals(period)) {
            orderNetProfitRankingList = orderNetProfitRankingService.calculateOrderNetProfitRankingByCategoryAndQuarterPeriod(category, year, quarter);
        } else if ("month-period".equals(period)) {
            orderNetProfitRankingList = orderNetProfitRankingService.calculateOrderNetProfitRankingByCategoryAndMonthPeriod(category, year, month);

        } else {
            //오류처리
        }

        model.addAttribute("orderNetProfitRankingList", orderNetProfitRankingList);
        model.addAttribute("period", period); // period 정보를 모델에 추가

        return "statistics/order/net-profit/ranking";
    }
}
