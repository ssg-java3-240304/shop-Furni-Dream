package com.fcrew.furnidream;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan  //현재 패키지 하위의 모든 @Mapper 인터페이스 구현체를 빈으로 등록한다.
public class FurnidreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(FurnidreamApplication.class, args);
	}

}
