package com.furnycrew.furnidream.admin.controller;

import com.furnycrew.furnidream.admin.model.dto.AdminDto;
import com.furnycrew.furnidream.admin.model.service.AdminService;
import com.furnycrew.furnidream.common.paging.PageCriteria;
import com.furnycrew.furnidream.salesmanagement.model.dto.SalesStatisticsByAgeDto;
import com.furnycrew.furnidream.salesmanagement.model.service.SalesMngService;
import com.furnycrew.furnidream.statistics.model.dao.OrderSalesStatisticsMapper;
import com.furnycrew.furnidream.statistics.model.dao.OrderStatusStatisticsMapper;
import com.furnycrew.furnidream.statistics.model.dto.OrderSalesStatisticsDto;
import com.furnycrew.furnidream.statistics.model.dto.OrderStatusStatisticsDto;
import com.furnycrew.furnidream.statistics.model.service.OrderSalesStatisticsService;
import com.furnycrew.furnidream.statistics.model.service.OrderStatusStatisticsService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;
    private final OrderSalesStatisticsService orderSalesStatisticsService;
    private final OrderStatusStatisticsService orderStatusStatisticsService;
    private final SalesMngService salesMngService;



    @GetMapping("/")
    public String index(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("adminId") == null) {
            return "redirect:/admin/login";
        }
        String adminId = (String) session.getAttribute("adminId");

        showStatistics(model);
        model.addAttribute("message", "🦄Welcome, " + adminId + "🦄");
        return "index";
    }

    private void findAllOrderStatus(Model model) {
        List<OrderStatusStatisticsDto> result = orderStatusStatisticsService.findAllOrderStatus();
        model.addAttribute("orderStatus", result);
    }

    private void calculateSalesStatistics(Model model) {
        List<OrderSalesStatisticsDto> result = orderSalesStatisticsService.calculateSalesStatistics(
                LocalDate.now().getYear());
        model.addAttribute("orderSales", result);
    }

    private void findSalesByAgeGroupAndTotalSales(Model model) {
        List<SalesStatisticsByAgeDto> salesStatisticsByAgeDtos = salesMngService.findSalesByAgeGroupAndTotalSales();

        for (SalesStatisticsByAgeDto salesStatisticsByAgeDto : salesStatisticsByAgeDtos) {
            System.out.println(salesStatisticsByAgeDto);
        }
        model.addAttribute("salesByAgeAndTotalSales", salesStatisticsByAgeDtos);
    }
    private void showStatistics(Model model) {
        findAllOrderStatus(model);
        calculateSalesStatistics(model);
        findSalesByAgeGroupAndTotalSales(model);
    }

    @GetMapping("/admin/login")
    public String login() {
        return "admin/login";
    }

    @PostMapping("/admin/login")
    public String login(@RequestParam("adminId") String adminId, @RequestParam("adminPw") String adminPw,
                        HttpServletRequest request, Model model) {
        AdminDto admin = adminService.login(adminId, adminPw);
        if (admin != null) { // 로그인 성공
            HttpSession session = request.getSession();
            session.setAttribute("adminId", admin.getAdminId());
            return "redirect:/";
        } else { // 로그인 실패
            model.addAttribute("error", "로그인 실패. 관리자 ID 또는 비밀번호를 확인하세요.");
            return "admin/login";
        }
    }

    @PostMapping("/admin/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/admin/login";
    }
}