package com.furnycrew.furnidream.common.enums;

import lombok.Getter;

/**
 * OrderStatus Enum 사용 가이드
 * 생성 및 접근방법 (3가지 방법이 있음)
 *   - 속성 이름으로 클래스 상수에 직접 접근
 *      OrderStatus orderStatus = OrderStatus.PENDING;
 *   - 속성 이름 문자열로 접근하기
 *      OrderStatus orderStatus = OrderStatus.valueOf("PENDING");
 *   - 코드 값으로 접근하기
 *      OrderStatus orderStatus = OrderStatus.of(2);    //PROCESSING 으로 세팅
 *      OrderStatus orderStatus = OrderStatus.of(3);    //SHIPPED 로 세팅
 *  위의 방법은 모두 동일한 결과를 얻을수 있습니다
 *
 *  값 읽기
 *      OrderStatus orderStatus = OrderStatus.of(2);    //PROCESSING 으로 세팅
 *      //객체를 통해 접근
 *      System.out.println(orderStatus);    //PROCESSING
 *      //선언 없이 클래스 상수로 직접 접근
 *      System.out.println(OrderStatus.PENDING) //PENDING
 *
 *  enum에서 code 읽어오기
 *      OrderStatus orderStatus = OrderStatus.CANCELLED; //CANCELLED 로 세팅
 *      System.out.println(orderStatus.getCode());   // 6
 *      System.out.println(OrderStatus.PROCESSING.getCode());    // 2   //PROCESSING의 code를 읽어옴
 *
 */

@Getter
public enum OrderStatus {
    PENDING(1),
    PROCESSING(2),
    SHIPPED(3),
    DELIVERED(4),
    COMPLETED(5),
    CANCELLED(6);

    private final int code;
    OrderStatus(int code) {
        this.code = code;
    }

    public static OrderStatus of(int code){
        return switch(code){
            case 1 -> PENDING;
            case 2 -> PROCESSING;
            case 3 -> SHIPPED;
            case 4 -> DELIVERED;
            case 5 -> COMPLETED;
            case 6 -> CANCELLED;
            default -> throw new IllegalArgumentException("존재하지 않는 상태입니다. : " + code);
        };
    }
}
