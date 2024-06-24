package com.furnycrew.furnidream.store.model.service;

import com.furnycrew.furnidream.store.model.dao.StoreMapper;
import com.furnycrew.furnidream.store.model.dto.StoreDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreService {
    private final StoreMapper storeMapper;

    // 상점 모든 정보 조회
    public List<StoreDto> findAll() {
        return storeMapper.findAll();
    }
}
