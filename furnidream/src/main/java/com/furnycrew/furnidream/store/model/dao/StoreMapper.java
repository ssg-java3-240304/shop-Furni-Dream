package com.furnycrew.furnidream.store.model.dao;

import com.furnycrew.furnidream.store.model.dto.StoreDto;

import java.util.List;

public interface StoreMapper {
    List<StoreDto> findAll(); // 상점 모든 정보 조회
}
