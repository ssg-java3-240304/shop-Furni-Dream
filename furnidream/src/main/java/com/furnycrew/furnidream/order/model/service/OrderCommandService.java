package com.furnycrew.furnidream.order.model.service;


import com.furnycrew.furnidream.common.enums.OrderStatus;
import com.furnycrew.furnidream.common.search.UpdateCriteria;
import com.furnycrew.furnidream.order.model.dao.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Slf4j
@Transactional(
        propagation = Propagation.REQUIRED,
        isolation = Isolation.READ_COMMITTED,
        rollbackFor = Exception.class
)
@Service
public class OrderCommandService {
    private final OrderMapper orderMapper;

    @Autowired
    public OrderCommandService(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }


    public int updateOrderStatus(UpdateCriteria updateCriteria) {
        int value = Integer.valueOf((String)updateCriteria.getValue());
        if(!updateCriteria.getName().equals("UpdateOrderStatus")){
            return -1;
        }else if(1<= value && value < 5){
            updateCriteria.setValue(value+1);
        }
        if(value == 2){
            Random random = new Random();
            // 13자리 난수 생성
            long min = 1000000000000L; // lower 설정
            long max = 9999999999999L; // upper 설정
            long tracking = min + (long) (random.nextDouble() * (max - min));
            UpdateCriteria tmpCriteria = new UpdateCriteria();
            tmpCriteria.setId(updateCriteria.getId());
            tmpCriteria.setValue(tracking);
            int res = orderMapper.updateTrackingNum(tmpCriteria);
        }
        int result = orderMapper.updateOrderStatus(updateCriteria);
        log.debug("updateOrderStatus service result = {}", result);
        return result;
    }

    public int cancelOrder(UpdateCriteria updateCriteria) {
        int value = Integer.valueOf((String)updateCriteria.getValue());
        int result = -1;
        UpdateCriteria tmpCriteria = new UpdateCriteria();
        log.debug("PENDING = {} / PROCESSING = {} / value = {}", OrderStatus.PENDING.getCode(), OrderStatus.PROCESSING.getCode(), value );
        if(OrderStatus.PENDING.getCode() == value || value == OrderStatus.PROCESSING.getCode()){
            log.debug("취소 조건 통과");
            tmpCriteria.setId(updateCriteria.getId());
            tmpCriteria.setValue(OrderStatus.CANCELLED.getCode());
            result = orderMapper.updateOrderStatus(tmpCriteria);
            result = orderMapper.createCancelOrder(tmpCriteria);
        }else{
            log.debug("취소 조건 통과 실패");
            return -1;
        }

        log.debug("cancel service result = {}", result);
        return result;
    }
}
