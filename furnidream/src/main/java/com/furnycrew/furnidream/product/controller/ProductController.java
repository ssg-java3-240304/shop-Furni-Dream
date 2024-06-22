package com.furnycrew.furnidream.product.controller;

import com.furnycrew.furnidream.product.model.dto.ProductDto;
import com.furnycrew.furnidream.product.model.service.ProductQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductQueryService productQueryService;

    @GetMapping("/list")
    public void list(Model model){
        log.info("GET /product/list");
        List<ProductDto> products = productQueryService.findAll();
        log.debug("products = {}", products);
//        model.addAllAttributes("products", products);
    }
}
