package com.furnycrew.furnidream.product.model.dao;

import com.furnycrew.furnidream.common.search.SearchCriteria;
import com.furnycrew.furnidream.product.model.dto.ProductDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    // 상품 전체 리스트
    List<ProductDto> findAll();
    List<ProductDto> findAll(@Param("offset") int offset, @Param("limit") int limit);
    List<ProductDto> findAllCategory();

    // 상품 등록
    int insertProduct(ProductDto productDto);

    // 상품 수정
    int updateProduct(ProductDto productDto);

    ProductDto findByProductId(Long productId);

    // 상품(상품명, 상품코드, 카테고리) 검색
    List<ProductDto> searchProduct(SearchCriteria searchCriteria);

    int countProducts();
}
