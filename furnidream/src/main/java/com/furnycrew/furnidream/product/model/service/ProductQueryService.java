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
@Transactional(readOnly = true)
public class ProductQueryService {
    private final ProductMapper productMapper;

    public List<ProductDto> findAll(int offset, int limit){
        return productMapper.findAll(offset, limit);
    }

    public ProductDto findByProductId(Long productId) {
        return productMapper.findByProductId(productId);
    }

    public List<ProductDto> searchProduct(String productName, String category, String productCode) {
        List<SearchCriteria> searchCriteriaList = new ArrayList<>();
        if (productName != null  && !productName.isEmpty()){
            searchCriteriaList.add(new SearchCriteria("product_name", productName, null, null));
        }
        if (category != null && !category.isEmpty()) {
            searchCriteriaList.add(new SearchCriteria("category", category, null, null));
        }
        if (productCode != null && !productCode.isEmpty()){
            searchCriteriaList.add(new SearchCriteria("product_code", productCode, null, null));
        }
        return productMapper.searchProduct((SearchCriteria) searchCriteriaList);
    }

    public int countProducts() {
        return productMapper.countProducts();
    }
}
