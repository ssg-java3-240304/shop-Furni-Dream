package com.furnycrew.furnidream.product.model.service;

import com.furnycrew.furnidream.product.model.dao.ProductMapper;
import com.furnycrew.furnidream.product.model.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class ProductCommandService {
    private final ProductMapper productMapper;

    public int insertProduct(ProductDto productDto) {
        return productMapper.insertProduct(productDto);
    }
}
