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

    @Test
    @DisplayName("상품ID로 메뉴 조회")
    void findByProductId() {
        // given
        Long productId = 1L;
        // when
        ProductDto product = productMapper.findByProductId(productId);
        // then
        assertThat(product)
                .isNotNull()
                .satisfies(
                        (_product) -> assertThat(_product.getProductId()).isEqualTo(productId),
                        (_product) -> assertThat(_product.getProductName()).isNotNull(),
                        (_product) -> assertThat(_product.getCategory()).isNotNull(),
                        (_product) -> assertThat(_product.getCostPrice()).isNotZero().isNotNull(),
                        (_product) -> assertThat(_product.getRetailPrice()).isNotZero().isNotNull(),
                        (_product) -> assertThat(_product.getProductCode()).isNotNull(),
                        (_product) -> assertThat(_product.getProductStatus()).isNotNull()
                                .satisfies(status -> assertThat(status).isIn(ProductStatus.AVAILABLE, ProductStatus.UNAVAILABLE))
                );
    }

    @Test
    @DisplayName("상품 정보 수정")
    void updateProduct() {
        // given 임의의 데이터생성
        String productName = "폭신폭신한 더블침대";
        String productImage = null;
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
        // 새 데이터 입력
        productMapper.insertProduct(productDto);
        Long productId = productDto.getProductId();
        // 수정할 데이터
        String newProductName = "뒹굴뒹굴거리며 잘 수 있는 킹사이즈 어린이 침대";
        String newProductImage = null;
        String newCategory = "침대";
        int newCostPrice = 87000;
        int newRetailPrice = 225000;
        int newStock = 35;
        String newDescription = "딩굴뎅굴뒹굴동글 바로 꿈나라로 gogo";
        String newProductCode = "BED019";
        int newDiscountRate = 5;
        int newShippingFee = 0;
        ProductStatus newProductStatus = ProductStatus.AVAILABLE;
        String newColor = "BROWN";
        int newSize = 250;
        productDto.setProductName(newProductName);
        productDto.setProductImage(newProductImage);
        productDto.setCategory(newCategory);
        productDto.setCostPrice(newCostPrice);
        productDto.setRetailPrice(newRetailPrice);
        productDto.setStock(newStock);
        productDto.setDescription(newDescription);
        productDto.setProductCode(newProductCode);
        productDto.setDiscountRate(newDiscountRate);
        productDto.setShippingFee(newShippingFee);
        productDto.setProductStatus(newProductStatus);
        productDto.setColor(newColor);
        productDto.setSize(newSize);
        // when
        int result = productMapper.updateProduct(productDto);
        ProductDto updatePtoductDto = productMapper.findByProductId(productId);
        // then
        assertThat(result).isEqualTo(1);
        // 등록된 행을 조회해서 컬럼값 비교
        assertThat(updatePtoductDto.getProductId()).isEqualTo(productId);
        assertThat(updatePtoductDto.getProductName()).isEqualTo(productName);
        assertThat(updatePtoductDto.getProductImage()).isEqualTo(productImage);
        assertThat(updatePtoductDto.getCategory()).isEqualTo(category);
        assertThat(updatePtoductDto.getCostPrice()).isEqualTo(costPrice);
        assertThat(updatePtoductDto.getRetailPrice()).isEqualTo(retailPrice);
        assertThat(updatePtoductDto.getStock()).isEqualTo(stock);
        assertThat(updatePtoductDto.getDescription()).isEqualTo(description);
        assertThat(updatePtoductDto.getProductCode()).isEqualTo(productCode);
        assertThat(updatePtoductDto.getDiscountRate()).isEqualTo(discountRate);
        assertThat(updatePtoductDto.getShippingFee()).isEqualTo(shippingFee);
        assertThat(updatePtoductDto.getProductStatus()).isEqualTo(productStatus);
        assertThat(updatePtoductDto.getColor()).isEqualTo(color);
        assertThat(updatePtoductDto.getSize()).isEqualTo(size);
    }
}