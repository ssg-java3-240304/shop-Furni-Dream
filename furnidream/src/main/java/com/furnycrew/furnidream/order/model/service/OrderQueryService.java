package com.furnycrew.furnidream.order.model.service;

import com.furnycrew.furnidream.common.search.SearchCriteria;
import com.furnycrew.furnidream.order.model.dao.OrderMapper;
import com.furnycrew.furnidream.order.model.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderQueryService {
    private static final Logger log = LoggerFactory.getLogger(OrderQueryService.class);
    private final OrderMapper orderMapper;

    public List<OrderDto> findOrdersByDateTime(SearchCriteria searchCriteria, int offset, int limit){
        return orderMapper.findOrdersByDateTime(searchCriteria, offset, limit);
    };

    public int countOrderByDateTime(SearchCriteria searchCriteria) {
        return orderMapper.countOrderByDateTime(searchCriteria);
    }
}
