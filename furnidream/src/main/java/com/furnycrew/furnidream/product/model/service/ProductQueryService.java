package com.furnycrew.furnidream.product.model.service;

import com.furnycrew.furnidream.product.model.dao.ProductMapper;
import com.furnycrew.furnidream.product.model.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductQueryService {
    private final ProductMapper productMapper;

    public List<ProductDto> findAll(){
        return productMapper.findAll();
    }

    public ProductDto findByProductId(Long productId) {
        return productMapper.findByProductId(productId);
    }
}
