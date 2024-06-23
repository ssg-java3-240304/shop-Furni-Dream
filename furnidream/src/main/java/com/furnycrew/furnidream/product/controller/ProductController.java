package com.furnycrew.furnidream.product.controller;

import com.furnycrew.furnidream.product.model.dto.ProductDto;
import com.furnycrew.furnidream.product.model.dto.ProductRegistDto;
import com.furnycrew.furnidream.product.model.service.ProductCommandService;
import com.furnycrew.furnidream.product.model.service.ProductQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductQueryService productQueryService;
    private final ProductCommandService productCommandService;

    @GetMapping("/list")
    public void list(Model model){
        log.info("GET /product/list");
        List<ProductDto> products = productQueryService.findAll();
        log.debug("products = {}", products);
//        model.addAllAttributes("products", products);
    }

    @PostMapping("/regist")
    public String regist(@ModelAttribute ProductRegistDto productRegistDto, RedirectAttributes redirectAttributes){
        log.info("POST /product/regist");
        ProductDto productDto = productRegistDto.toProductDto();
        int result = productCommandService.insertProduct(productDto);
        redirectAttributes.addFlashAttribute("message", "✅상품이 성공적으로 등록되었습니다");
        return "redirect:/product/list";
    }
}
