package com.furnycrew.furnidream.admin.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto {
    Long adminPk;
    String adminId;
    String adminPw;
    LocalDateTime createdAt;
}
