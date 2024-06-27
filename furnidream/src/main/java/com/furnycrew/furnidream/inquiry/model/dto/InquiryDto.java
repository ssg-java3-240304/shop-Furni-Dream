package com.furnycrew.furnidream.inquiry.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InquiryDto {
    private long inquiryId;
    private long customerId;
    private String name;
    private LocalDateTime createdAt;
    private String title;
    private String content;
    private String status;
    private String response;
}
