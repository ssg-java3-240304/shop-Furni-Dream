package com.furnycrew.furnidream.product.model.service;

import com.furnycrew.furnidream.common.search.SearchCriteria;
import com.furnycrew.furnidream.product.model.dao.ProductMapper;
import com.furnycrew.furnidream.product.model.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductQueryService {
    private final ProductMapper productMapper;

    public List<ProductDto> findAll(int offset, int limit){
        return productMapper.findAll(offset, limit);
    }

    public ProductDto findByProductId(Long productId) {
        return productMapper.findByProductId(productId);
    }

    public List<ProductDto> searchProduct(String searchType, String keyword) {
//        SearchCriteria searchCriteriaList = new SearchCriteria();
//        if (searchType != null  && !searchType.isEmpty()){
//            new SearchCriteria("product_name", productName, null, null);
//        }
//        if (keyword != null && !keyword.isEmpty()) {
//            new SearchCriteria("category", category, null, null);
//        }
//        if (productCode != null && !productCode.isEmpty()){
//            new SearchCriteria("product_code", productCode, null, null);
//        }
        return productMapper.searchProduct(searchType, keyword);
    }

    public int countProducts() {
        return productMapper.countProducts();
    }

    public List<ProductDto> findAllCategory() {
        return productMapper.findAllCategory();
    }

    public ProductDto findByProductCode(String productCode) {
        return productMapper.findByProductCode(productCode);
    }
}
