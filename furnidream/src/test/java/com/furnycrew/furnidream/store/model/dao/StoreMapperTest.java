package com.furnycrew.furnidream.store.model.dao;

import com.furnycrew.furnidream.store.model.dto.StoreDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
        String businessNum = "100-01-00002";
        String storeName = "FurnnyCrew";
        String ceoName = "퍼니드림";
        String ceoPhone = "010-1111-1111";
        String ceoEmail = "furnidream@gmail.com";
        String businessAddress = "서울특별시 강남구 삼성로 534 SAC아트홀 6층";
        String businessStatus = "소매업";
        String businessCategory = "가구";
        String stampImage = null;
        char mailOrderYn = 'N';
        String mailOrderNum = null;
        StoreDto storeDto = new StoreDto(null, businessNum, storeName, ceoName, ceoPhone, ceoEmail, businessAddress, businessStatus, businessCategory, stampImage, mailOrderYn, mailOrderNum);

        // when
        int result = storeMapper.insertStore(storeDto);

        // then
        assertThat(result).isEqualTo(1);
        assertThat(storeDto.getStoreId()).isNotZero();
    }
}