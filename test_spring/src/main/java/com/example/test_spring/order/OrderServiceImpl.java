package com.example.test_spring.order;

import com.example.test_spring.discount.DiscountPolicy;
import com.example.test_spring.member.Member;
import com.example.test_spring.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor //lombok의 기능 1 - final 붙은 것을 보고 자동으로 생성자를 맏들어줌
public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    //@Autowired private DiscountPolicy discountPolicy   //의존관계 자동 주입 방법 3 - 필드 주입

    // @RequiredArgsConstructor 있으면 밑에 코드 없어도 됨.
    @Autowired //의존관계 자동 주입 방법 1 - 생성자 주입 (생성자가 하나만 있으면 @Autowired 생략 가능)
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //조회 대상 빈이 2개 이상일 떄 Qualifier 로 해당 파일에 이름 지정해주면  생성자 주입 할 때 같은 이름의 빈을 찾음
//    public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

//
//    @Autowired //의존관계 자동 주입 방법 2 - 수정자 주입(setter 주입)
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy=discountPolicy;
//    }


//    @Autowired  //의존관계 자동 주입 방법 4 - 일반 메서드 주입
//    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository= memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
