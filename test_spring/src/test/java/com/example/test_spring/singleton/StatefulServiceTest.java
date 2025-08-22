package com.example.test_spring.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton(){
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = context.getBean(StatefulService.class);
        StatefulService statefulService2 = context.getBean(StatefulService.class);

        //ThreadA : A 사용자가 10000원 주문
        int userAPrice =statefulService1.order("userA",10000);
        //ThreadB : B 사용자가 20000원 주문
        int userBPrice = statefulService2.order("userB",20000);

        //ThreadA: A 사용자 주문 금액 조회
        //int price = statefulService1.getPrice();
        //System.out.println("price: " + price); // 20000원이 나옴. B가 값을 바꿔버림
        System.out.println("price: " + userAPrice);
        //Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}