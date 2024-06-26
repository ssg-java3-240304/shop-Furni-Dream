package com.furnycrew.furnidream.order.controller;

import com.furnycrew.furnidream.common.paging.PageCriteria;
import com.furnycrew.furnidream.common.search.SearchCriteria;
import com.furnycrew.furnidream.order.model.dto.OrderDto;
import com.furnycrew.furnidream.order.model.service.OrderQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/order")
public class OrderController {
    private final OrderQueryService orderQueryService;


    public OrderController(OrderQueryService orderQueryService) {
        this.orderQueryService = orderQueryService;
    }

    @GetMapping("/list")
    public void list(@RequestParam(defaultValue = "") String viewType,
                     @RequestParam(defaultValue = "1") int page,
                     @RequestParam(defaultValue = "10") int limit,
                     Model model){
        log.info("GET /menu/list?page={}&limit={}", page, limit);
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setName(viewType);
        // 1. 컨텐츠 영역 (limit쿼리)
        int offset = (page - 1) * limit; // 1페이지 - 0, 2페이지 - 10, 3페이지 - 20, ...
        List<OrderDto> orders = orderQueryService.findOrdersByDateTime(searchCriteria, offset, limit);
        log.debug("orders = {}", orders);
        model.addAttribute("orders", orders);

        // 2. 페이지바 영역 (html)
        int totalCount = orderQueryService.countOrderByDateTime(searchCriteria); // 전체 주문가능한 메뉴수
        log.debug("totalCount = {}", totalCount);
        String url = "list"; // 간단히 상대경로 사용
        model.addAttribute("pageCriteria", new PageCriteria(page, limit, totalCount, url));
    }

    @GetMapping("/detail/{orderCode}")
    public String detail(@PathVariable Long orderCode, Model model){
        log.debug("Get order/detail/{}", orderCode);
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setName("orderCode");
        searchCriteria.setValue(orderCode);
        OrderDto orderDto = orderQueryService.getOrderDetail(searchCriteria);
        log.debug("orderDto = {}", orderDto);
        model.addAttribute("order", orderDto);
        return "order/detail";
    }
}
