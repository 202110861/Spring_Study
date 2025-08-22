package com.example.test_spring;

import com.example.test_spring.discount.DiscountPolicy;
import com.example.test_spring.discount.FixDiscountPolicy;
import com.example.test_spring.discount.RateDiscountPolicy;
import com.example.test_spring.member.MemberRepository;
import com.example.test_spring.member.MemberService;
import com.example.test_spring.member.MemberServiceImpl;
import com.example.test_spring.member.MemoryMemberRepository;
import com.example.test_spring.order.OrderService;
import com.example.test_spring.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//스프링에서는 설정정보에 @Configuration을 적어줘야 함.
@Configuration
//AppConfig 를 IoC 컨테이너 또는 DI 컨테이너 라고 함.
public class AppConfig {

    //각 메서드에 @Bean을 붙여야 함.
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
