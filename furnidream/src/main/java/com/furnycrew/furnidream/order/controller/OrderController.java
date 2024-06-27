package com.furnycrew.furnidream.order.controller;

import com.furnycrew.furnidream.common.enums.OrderStatus;
import com.furnycrew.furnidream.common.paging.PageCriteria;
import com.furnycrew.furnidream.common.search.SearchCriteria;
import com.furnycrew.furnidream.common.search.UpdateCriteria;
import com.furnycrew.furnidream.order.model.dto.OrderDto;
import com.furnycrew.furnidream.order.model.service.OrderCommandService;
import com.furnycrew.furnidream.order.model.service.OrderQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/order")
public class OrderController {
    private final OrderQueryService orderQueryService;
    private final OrderCommandService orderCommandService;


    public OrderController(OrderQueryService orderQueryService, OrderCommandService orderCommandService) {
        this.orderQueryService = orderQueryService;
        this.orderCommandService = orderCommandService;
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

    @Transactional
    @PostMapping("/updateOrderStatus")
    public String updateOrderStatus(@ModelAttribute UpdateCriteria updateCriteria, RedirectAttributes redirectAttributes){
        log.debug("Post updateOrderStatus/{}", updateCriteria);
        log.info("Post /updateOrderStatus");

        int value = Integer.valueOf((String)updateCriteria.getValue());
        int result = orderCommandService.updateOrderStatus(updateCriteria);
        if (result == -1) {
            redirectAttributes.addFlashAttribute("message", "주문상태 변경에 실패했습니다");
        }else{
            redirectAttributes.addFlashAttribute("message", "성공적으로 주문상태를"+ OrderStatus.of(value) +"(으)로 변경했습니다");
        }
        return "redirect:/order/detail/"+updateCriteria.getId();
    }

    @PostMapping("/cancel")
    public String cancelOrder(@ModelAttribute UpdateCriteria updateCriteria, RedirectAttributes redirectAttributes){
        log.debug("Post cancelOrder/{}", updateCriteria);
        log.info("Post /cancelOrder");
        int result = orderCommandService.cancelOrder(updateCriteria);
        if (result == -1) {
            redirectAttributes.addFlashAttribute("message", "주문상태 변경에 실패했습니다");
            log.debug("취소 실패");
        }else{
            redirectAttributes.addFlashAttribute("message", "성공적으로 주문상태를"+ OrderStatus.CANCELLED +"(으)로 변경했습니다");
            log.debug("취소 성공");
        }
        return "redirect:/order/detail/"+updateCriteria.getId();
    }


}
