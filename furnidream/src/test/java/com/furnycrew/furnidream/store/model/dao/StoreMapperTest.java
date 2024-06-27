package com.furnycrew.furnidream.store.model.dao;

import com.furnycrew.furnidream.common.enums.ProductStatus;
import com.furnycrew.furnidream.product.model.dto.ProductDto;
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
    @DisplayName("한 상점의 모든 정보 조회")
    void test1() {
        // given
        StoreDto store = storeMapper.findAll();
        // then
        assertThat(store).isNotNull();
    }

    @Test
    @DisplayName("상점 ID 일치하는 한 건 조회")
    void test2() {
        // given
        Long storeId = 1L;
        // when
        StoreDto store = storeMapper.findByStoreId(storeId);
        // then
        assertThat(store)
                .isNotNull()
                .satisfies(
                        (_store) -> assertThat(_store.getStoreId()).isEqualTo(storeId),
                        (_store) -> assertThat(_store.getBusinessNum()).isNotNull(),
                        (_store) -> assertThat(_store.getStoreName()).isNotNull(),
                        (_store) -> assertThat(_store.getCeoName()).isNotNull(),
                        (_store) -> assertThat(_store.getBusinessAddress()).isNotNull(),
                        (_store) -> assertThat(_store.getBusinessStatus()).isNotNull(),
                        (_store) -> assertThat(_store.getBusinessCategory()).isNotNull(),
                        (_store) -> assertThat(_store.getMailOrderYn()).isNotNull()
                );
    }

    @Test
    @DisplayName("상점 정보 등록")
    void test3() {
        // given
        String businessNum = "100-01-00002";
        String storeName = "FurnnyCrew";
        String ceoName = "퍼니드림";
        String ceoPhone = "010-1111-1111";
        String ceoEmail = "furnidream@gmail.com";
        String businessAddress = "서울특별시 강남구 삼성로 534 SAC아트홀 6층";
        String businessStatus = "소매업";
        String businessCategory = "가구";
//        String stampImage = null;
        String mailOrderYn = "N";
        String mailOrderNum = null;
        StoreDto storeDto = new StoreDto(null, businessNum, storeName, ceoName, ceoPhone, ceoEmail, businessAddress, businessStatus, businessCategory, mailOrderYn, mailOrderNum);

        // when
        int result = storeMapper.insertStore(storeDto);

        // then
        assertThat(result).isEqualTo(1);
        assertThat(storeDto.getStoreId()).isNotZero();
    }

    @Test
    @DisplayName("최신 상점 수정")
    void test4() {
        // given
        String businessNum = "100-01-00002";
        String storeName = "FurnnyCrew";
        String ceoName = "퍼니드림";
        String ceoPhone = "010-1111-1111";
        String ceoEmail = "furnidream@gmail.com";
        String businessAddress = "서울특별시 강남구 삼성로 534 SAC아트홀 6층";
        String businessStatus = "소매업";
        String businessCategory = "가구";
//        String stampImage = null;
        String mailOrderYn = "N";
        String mailOrderNum = null;
        StoreDto storeDto = new StoreDto(null, businessNum, storeName, ceoName, ceoPhone, ceoEmail, businessAddress, businessStatus, businessCategory, mailOrderYn, mailOrderNum);
        // 새 데이터 입력
        storeMapper.insertStore(storeDto);
        Long storeId = storeDto.getStoreId();
        // 수정할 데이터
        String newStoreName = "퍼니크루";
        String newCeoName = "furniDream";
        storeDto.setStoreName(newStoreName);
        storeDto.setCeoName(newCeoName);
        // when
        int result = storeMapper.updateStore(storeDto);
        // then
        assertThat(result).isEqualTo(1);
        // 등록된 행을 조회해서 컬럼값 비교
        StoreDto storeDto2 = storeMapper.findByStoreId(storeId);
        assertThat(storeDto2.getStoreId()).isEqualTo(storeId);
        assertThat(storeDto2.getStoreName()).isEqualTo(newStoreName);
        assertThat(storeDto2.getCeoName()).isEqualTo(newCeoName);
    }
}