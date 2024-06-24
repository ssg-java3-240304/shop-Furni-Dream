package com.furnycrew.furnidream.store.controller;

import com.furnycrew.furnidream.store.model.dto.StoreDto;
import com.furnycrew.furnidream.store.model.service.StoreService;
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
@RequestMapping("/store")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    // 상점 모든 정보 조회
    @GetMapping("/list")
    public void list(Model model) {
        log.info("GET /store/list");
        List<StoreDto> stores = storeService.findAll();
        log.debug("stores : {}", stores);
        model.addAttribute("stores", stores);
    }
}
