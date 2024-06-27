package com.furnycrew.furnidream.common.enums;

import lombok.Getter;

/**
 * ===enum 사용방법===
 * 객체 세팅
 *      Gender gen = Gender.of("남성"); // M 값을 가지는 Gender enum 객체를 gen에 저장합니다.
 *      Gender gen = Gender.valueOf("M"); // M 값을 가지는 Gender enum 객체를 gen에 저장합니다.
 *      위의 두 동작이 동일한 결과를 갖습니다.
 *
 * enum 값 읽기
 *  enum 값 읽기
 *      System.out.println(gen);  //M
 *
 *  enum 객체에 담긴 한글명 가져오기
 *      Gender gen = Gender.valueOf("F");    // 여성 Gender 객체 생성
 *      String koreanGender = gen.getKorean();   // String형으로 한글 값 가져오기
 *      System.out.println(gen);  // 여성
 *
 */
@Getter
public enum Gender {
    F("여성"),
    M("남성");

    private final String korean;
    Gender(String korean) {
        this.korean = korean;
    }

    public static Gender of(String korean){
        return switch(korean){
            case "여성" -> F;
            case "남성" -> M;
            default -> throw new IllegalArgumentException("존재하지 않는 한글 성별입니다. : " + korean);
        };
    }

}
