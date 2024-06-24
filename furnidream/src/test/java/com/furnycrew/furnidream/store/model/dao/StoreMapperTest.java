package com.furnycrew.furnidream.store.model.dao;

import com.furnycrew.furnidream.store.model.dto.StoreDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StoreMapperTest {
    @Autowired
    private StoreMapper storeMapper;

    @Test
    @DisplayName("상점 모든 정보 조회")
    void test1() {
        // given
        List<StoreDto> stores = storeMapper.findAll();
        // then
        assertThat(stores)
                .isNotNull()
                .isNotEmpty()
                .allMatch((store) -> store != null);
    }

    @Test
    @DisplayName("상점 정보 등록")
    void test2() {
        // given

        // when
        // then
    }
}