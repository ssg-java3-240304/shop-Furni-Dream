package com.furnycrew.furnidream.store.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreRegistDto {
    private String businessNum;
    private String storeName;
    private String ceoName;
    private String ceoPhone;
    private String ceoEmail;
    private String businessAddress;
    private String businessStatus;
    private String businessCategory;
//    private String stampImage;
    private String mailOrderYn;
    private String mailOrderNum;

    public StoreDto toStoreDto() {
        return new StoreDto(null, this.businessNum, this.storeName, this.ceoName, this.ceoPhone, this.ceoEmail, this.businessAddress, this.businessStatus, this.businessCategory, this.mailOrderYn, this.mailOrderNum);
    }
}
