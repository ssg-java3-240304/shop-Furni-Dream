package com.furnycrew.furnidream.inquiry.model.dao;

import com.furnycrew.furnidream.common.search.SearchCriteria;
import com.furnycrew.furnidream.inquiry.model.dto.InquiryDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class InquiryMapperTest {

    @Autowired
    InquiryMapper inquiryMapper;

    @DisplayName("모든 1:1문의 목록 조회")
    @Test
    public void test1() {
        //given
        SearchCriteria searchCriteria = new SearchCriteria();
        //when
        List<InquiryDto> inquiries = inquiryMapper.getInquiries(searchCriteria, 0, 10);
        //then
        assertThat(inquiries)
                .isNotNull()
                .isNotEmpty()
                .hasSize(10)
                .allSatisfy((inquiry)->{
                    assertThat(inquiry.getInquiryId()).isNotZero();
                    assertThat(inquiry.getCustomerId()).isNotZero();
                    assertThat(inquiry.getCreatedAt()).isNotNull();
                    assertThat(inquiry.getTitle()).isNotNull();
                    assertThat(inquiry.getContent()).isNotNull();
                    assertThat(inquiry.getStatus()).isNotNull();
                });

    }
}