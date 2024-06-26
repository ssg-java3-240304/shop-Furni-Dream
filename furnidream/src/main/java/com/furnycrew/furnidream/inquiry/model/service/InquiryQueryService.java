package com.furnycrew.furnidream.inquiry.model.service;

import com.furnycrew.furnidream.common.search.SearchCriteria;
import com.furnycrew.furnidream.inquiry.model.dao.InquiryMapper;
import com.furnycrew.furnidream.inquiry.model.dto.InquiryDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InquiryQueryService {
    private static final Logger log = LoggerFactory.getLogger(InquiryQueryService.class);
    private final InquiryMapper inquiryMapper;

    public List<InquiryDto> getInquiries(SearchCriteria searchCriteria, int offset, int limit) {
        return inquiryMapper.getInquiries(searchCriteria, offset, limit);
    }

    public int countInquiry(SearchCriteria searchCriteria) {
        return inquiryMapper.countInquiry(searchCriteria);
    }
}
