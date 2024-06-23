package com.furnycrew.furnidream.customer.model.dto;

import com.furnycrew.furnidream.common.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private long customerId;
    private String name;
    private char gender;
    private int age;
    private String address;
    private String phone;
}
