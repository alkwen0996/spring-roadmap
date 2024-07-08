package com.hello.core;


import com.hello.core.discount.DiscountPolicy;
import com.hello.core.discount.RateDiscountPolicy;
import com.hello.core.member.MemberService;
import com.hello.core.member.MemberServiceImpl;
import com.hello.core.member.MemoryMemberRepository;
import com.hello.core.order.OrderService;
import com.hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

@Configuration
@ComponentScan
        (basePackages = "com.hello.core.member", // 탐색을 시작할 위치를 지정한다. -> 탐색 범위 최소화
        basePackageClasses = AutoAppConfig.class, // 지정한 클래스의 패키지를 탐색 시작 위치로 지정한다
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
// 기존 AppConfig 빈 등록 방지를 위해(테스트 목적)
// 최근에는 설정 정보 클래스의 위치를 프로젝트 최상단에 위치시키는 방식으로 한다. 스프링 부트도 이 방법을 기본으로 제공한다.
public class AutoAppConfig {
}
