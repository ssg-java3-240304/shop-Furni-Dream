package com.furnycrew.furnidream.inquiry.controller;


import com.furnycrew.furnidream.common.paging.PageCriteria;
import com.furnycrew.furnidream.common.search.SearchCriteria;
import com.furnycrew.furnidream.common.search.UpdateCriteria;
import com.furnycrew.furnidream.inquiry.model.dto.InquiryDto;
import com.furnycrew.furnidream.inquiry.model.service.InquiryCommandService;
import com.furnycrew.furnidream.inquiry.model.service.InquiryQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/inquiry")
public class InquiryController {
    private final InquiryCommandService inquiryCommandService;
    private final InquiryQueryService inquiryQueryService;

    public InquiryController(InquiryCommandService inquiryCommandService, InquiryQueryService inquiryQueryService) {
        this.inquiryCommandService = inquiryCommandService;
        this.inquiryQueryService = inquiryQueryService;
    }

    @GetMapping("/list")
    public String list(@RequestParam(defaultValue = "") String viewType,
                    @RequestParam(defaultValue = "1") int page,
                    @RequestParam(defaultValue = "10") int limit,
                    Model model){

        log.info("GET /menu/list?page={}&limit={}", page, limit);
        SearchCriteria searchCriteria = new SearchCriteria();
        if(!viewType.isEmpty()) {
            searchCriteria.setName("status");
            searchCriteria.setValue(viewType);
        }
        log.debug("Get searchCriteria = {}", searchCriteria);
        // 1. 컨텐츠 영역 (limit쿼리)
        int offset = (page - 1) * limit; // 1페이지 - 0, 2페이지 - 10, 3페이지 - 20, ...
        List<InquiryDto> inquiries = inquiryQueryService.getInquiries(searchCriteria, offset, limit);
        log.debug("inquiries = {}", inquiries);
        model.addAttribute("inquiries", inquiries);

        // 2. 페이지바 영역 (html)
        int totalCount = inquiryQueryService.countInquiry(searchCriteria); // 전체 주문가능한 메뉴수
        log.debug("totalCount = {}", totalCount);
        String url = "list"; // 간단히 상대경로 사용
        model.addAttribute("pageCriteria", new PageCriteria(page, limit, totalCount, url));
        return "inquiry/list";
    }

    @GetMapping("/detail/{inquiryId}")
    public String detail(@PathVariable Long inquiryId, Model model){
        log.debug("Get inquiry/detail/{}", inquiryId);
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setName("inquiryId");
        searchCriteria.setValue(inquiryId);
        InquiryDto inquiry = inquiryQueryService.getInquiryDetail(searchCriteria);
        log.debug("inquiry = {}", inquiry);
        model.addAttribute("inquiry", inquiry);
        return "inquiry/detail";
    }

    @PostMapping("/addResponse")
    public String addResponse(@ModelAttribute UpdateCriteria updateCriteria, RedirectAttributes redirectAttributes){
        log.debug("Get inquiry/addResponse/{}", updateCriteria);
        updateCriteria.setName("Response");
        int result = inquiryCommandService.addResponse(updateCriteria);
        return "redirect:/inquiry/detail/"+updateCriteria.getId();
    }

}
