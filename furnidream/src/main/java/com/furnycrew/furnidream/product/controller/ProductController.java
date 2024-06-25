package com.furnycrew.furnidream.product.controller;

import com.furnycrew.furnidream.common.paging.PageCriteria;
import com.furnycrew.furnidream.common.search.SearchCriteria;
import com.furnycrew.furnidream.product.model.dto.ProductDto;
import com.furnycrew.furnidream.product.model.dto.ProductRegistDto;
import com.furnycrew.furnidream.product.model.dto.ProductUpdateDto;
import com.furnycrew.furnidream.product.model.service.ProductCommandService;
import com.furnycrew.furnidream.product.model.service.ProductQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public void list(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int limit,
            Model model){
        log.info("GET /product/list?page{}&limit={}", page, limit);
        // 1. 컨텐츠 영역 (limit 쿼리)
        int offset = (page - 1) * limit;
        List<ProductDto> products = productQueryService.findAll(offset, limit);
        log.debug("products = {}", products);
        model.addAttribute("products", products);

        // 2. 페이지바 영역(html)
        int totalCount = productQueryService.countProducts();
        String url = "list";
        model.addAttribute("pageCriteria", new PageCriteria(page, limit, totalCount, url));
    }

    @GetMapping("/regist")
    public void regist(Model model){
        log.info("GET /product/regist");
        List<ProductDto> categories = productQueryService.findAllCategory();
        model.addAttribute("categories", categories);
    }

    @PostMapping("/regist")
    public String regist(@ModelAttribute ProductRegistDto productRegistDto, RedirectAttributes redirectAttributes){
        log.info("POST /product/regist");
        ProductDto productDto = productRegistDto.toProductDto();
        int result = productCommandService.insertProduct(productDto);
        redirectAttributes.addFlashAttribute("message", "✅상품이 성공적으로 등록되었습니다");
        return "redirect:/product/list";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute ProductUpdateDto productUpdateDto, RedirectAttributes redirectAttributes){
        log.info("POST /product/update");
        ProductDto productDto = productUpdateDto.toProductDto();
        int result = productCommandService.updateProduct(productDto);
        redirectAttributes.addFlashAttribute("message", "🔄️상품이 성공적으로 수정되었습니다.");
        return "redirect/product/update";
    }

    @GetMapping("/datail/{productId}")
    public String detail(Model model, @PathVariable("productId") Long productId){
        log.info("GET /product/deatail/{}", productId);
        ProductDto product = productQueryService.findByProductId(productId);
        model.addAttribute("product", product);
        return "product/detail";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "productName", required = false) String productName,
                         @RequestParam(value = "category", required = false) String category,
                         @RequestParam(value = "productCode", required = false) String productCode,
                         Model model) {
        log.info("GET /product/search?productName={}&category={}&productCode={}", productName, category, productCode);
        List<ProductDto> products = productQueryService.searchProduct(productName, category, productCode);
        model.addAttribute("products", products);
        return "product/search";
    }
}
