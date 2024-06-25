package com.furnycrew.furnidream.statistics.controller;

import com.furnycrew.furnidream.statistics.model.dto.OrderCountRankingDto;
import com.furnycrew.furnidream.statistics.model.service.OrderCountRankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/statistics/order/count-ranking")
public class OrderCountRankingController {
    private final OrderCountRankingService orderCountRankingService;

    @GetMapping("/all/{period}")
    public String calculateOrderCountRankingByAll(@PathVariable String period, Integer year, Integer quarter,Integer month, Model model) {
        List<OrderCountRankingDto> orderCountRankingList = null;

        if ("all-period".equals(period)) {
            orderCountRankingList = orderCountRankingService.calculateOrderCountRankingByAllPeriod();
        } else if ("quarter-period".equals(period)) {
            orderCountRankingList = orderCountRankingService.calculateOrderCountRankingByQuarterPeriod(year, quarter);
        } else if ("month-period".equals(period)) {
            orderCountRankingList = orderCountRankingService.calculateOrderCountRankingByMonthPeriod(year, month);

        }else{
            //오류처리
        }

        model.addAttribute("orderCountRankingList", orderCountRankingList);
        model.addAttribute("period", period); // period 정보를 모델에 추가

        return "statistics/order/count-ranking/ranking";
    }

    @GetMapping("/category/{period}")
    public String calculateOrderCountRankingByCategory(@PathVariable String period,String category, Integer year, Integer quarter,Integer month, Model model) {
        List<OrderCountRankingDto> orderCountRankingList = null;

        if ("all-period".equals(period)) {
            orderCountRankingList = orderCountRankingService.calculateOrderCountRankingByCategoryAndAllPeriod(category);
        } else if ("quarter-period".equals(period)) {
            orderCountRankingList = orderCountRankingService.calculateOrderCountRankingByCategoryAndQuarterPeriod(category, year, quarter);
        } else if ("month-period".equals(period)) {
            orderCountRankingList = orderCountRankingService.calculateOrderCountRankingByCategoryAndMonthPeriod(category, year, month);

        }else{
            //오류처리
        }

        model.addAttribute("orderCountRankingList", orderCountRankingList);
        model.addAttribute("period", period); // period 정보를 모델에 추가

        return "statistics/order/count-ranking/ranking";
    }
}
