package com.furnycrew.furnidream.inquiry.model.dao;

import com.furnycrew.furnidream.common.search.SearchCriteria;
import com.furnycrew.furnidream.inquiry.model.dto.InquiryDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@Mapper
public interface InquiryMapper {

    List<InquiryDto> getInquiries(@Param("searchCriteria") SearchCriteria searchCriteria, @Param("offset") int offset, @Param("limit") int limit);

    int countInquiry(SearchCriteria searchCriteria);
}
