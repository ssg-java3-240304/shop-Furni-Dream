package com.furnycrew.furnidream.product.model.dao;

import com.furnycrew.furnidream.product.model.dto.ProductDto;
import com.furnycrew.furnidream.product.model.dto.ProductStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;
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


    @Test
    @DisplayName("상품 등록")
    void insertProduct() {
        // given
        String productName = "폭신폭신한 더블침대";
        String productImage = " ";
        String category = "침대";
        int costPrice = 75000;
        int retailPrice = 135000;
        int stock = 45;
        String description = "폭신한 침대에서 잠이 솔솔~~!";
        String productCode = "BED054";
        int discountRate = 5;
        int shippingFee = 0;
        ProductStatus productStatus = ProductStatus.AVAILABLE;
        String color = "WHITE";
        int size = 250;
        ProductDto productDto = new ProductDto(
                null, productName, productImage, category, costPrice, retailPrice, stock, description, productCode,
                discountRate, shippingFee, productStatus, color, size);
        // when
        int result = productMapper.insertProduct(productDto);
        // then
        assertThat(result).isEqualTo(1);
        assertThat(productDto.getProductId()).isNotZero();
    }
}