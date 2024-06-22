package com.furnycrew.furnidream.product.model.dao;

import com.furnycrew.furnidream.product.model.dto.ProductDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductMapperTest {
    @Autowired
    private ProductMapper productMapper;

    @Test
    @DisplayName("상품 전체 조회")
    void findAll() {
        // given
        // when
        List<ProductDto> products = productMapper.findAll();
        // then
        assertThat(products)
                .isNotNull()
                .isNotEmpty()
                .allMatch((product) -> product != null);
    }
}