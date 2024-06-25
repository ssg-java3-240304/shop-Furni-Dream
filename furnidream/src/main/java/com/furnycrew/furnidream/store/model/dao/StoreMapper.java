package com.furnycrew.furnidream.store.model.dao;

import com.furnycrew.furnidream.store.model.dto.StoreDto;

import java.util.List;

public interface StoreMapper {
    StoreDto findAll(); // 한 상점의 모든 정보 조회

    int insertStore(StoreDto storeDto); // 상점 등록

    int updateStore(StoreDto storeDto); // 상점 수정

    StoreDto findByStoreId(Long storeId); // 상점 ID 일치하는 한 건 조회
}
