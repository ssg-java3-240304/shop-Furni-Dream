package com.furnycrew.furnidream.statistics.controller;

import com.furnycrew.furnidream.statistics.model.dao.OrderStatusStatisticsMapper;
import com.furnycrew.furnidream.statistics.model.dto.OrderStatusStatisticsDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/statistics/order/status")
public class OrderStatusStatisticsController {
    private final OrderStatusStatisticsMapper orderStatusStatisticsMapper;
    @GetMapping()
    public String calculateSalesStatistics(Model model) {
        List<OrderStatusStatisticsDto> result = orderStatusStatisticsMapper.findAllOrderStatus();
        model.addAttribute("result", result);

        return "statistics/order/status/chart";
    }

}
