package com.furnycrew.furnidream.inquiry.model.service;


import com.furnycrew.furnidream.common.enums.InquiryStat;
import com.furnycrew.furnidream.common.search.UpdateCriteria;
import com.furnycrew.furnidream.inquiry.model.dao.InquiryMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional(
        propagation = Propagation.REQUIRED,
        isolation = Isolation.READ_COMMITTED,
        rollbackFor = Exception.class
)
@Service
public class InquiryCommandService {
    @Autowired
    private final InquiryMapper inquiryMapper;

    public InquiryCommandService(InquiryMapper inquiryMapper) {
        this.inquiryMapper = inquiryMapper;
    }

    public int addResponse(UpdateCriteria updateCriteria) {

        return inquiryMapper.addResponse(updateCriteria, InquiryStat.Answered);
    }
}
