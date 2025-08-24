package com.example.test_spring.order;

import com.example.test_spring.AppConfig;
import com.example.test_spring.member.Grade;
import com.example.test_spring.member.Member;
import com.example.test_spring.member.MemberService;
import com.example.test_spring.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    AppConfig appConfig = new AppConfig();

    MemberService memberService = appConfig.memberService();
    OrderService orderService = appConfig.orderService();

    @Test
    void createOrder(){
        Long memberId  = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }

    @Test
    void fieldInjectionTest(){
        //OrderService orderService = new OrderServiceImpl();
        orderService.createOrder(1L, "itemA", 10000);

    }
}
