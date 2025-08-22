package com.example.test_spring.discount;

import com.example.test_spring.member.Grade;
import com.example.test_spring.member.Member;


public class FixDiscountPolicy implements DiscountPolicy{
    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){
            return discountFixAmount;
        } else{
            return 0;
        }

    }
}
