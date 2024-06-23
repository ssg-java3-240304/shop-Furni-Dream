package com.furnycrew.furnidream.customer.model.dto;

import com.furnycrew.furnidream.common.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private long customer_id;
    private String name;
    private Gender gender;
    private int age;
    private String address;
    private String Phone;
}
