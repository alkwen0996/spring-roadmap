package com.hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService bean1 = ac.getBean(StatefulService.class);
        StatefulService bean2 = ac.getBean(StatefulService.class);

        System.out.println(bean1);
        System.out.println(bean2);

        // ThreadA: A 사용자 만원 주문
        int userA = bean1.order("userA", 10000);
        // ThreadB: B 사용자 만원 주문
        bean2.order("userB", 20000);

        //ThreadA 사용자A 주문 금액 조회
//        int price = bean1.getPrice();
        System.out.println("price = " + bean1);

        Assertions.assertThat(userA).isEqualTo(10000);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}