package com.example.springboot.discount;

import com.example.springboot.member.Member;
import com.example.springboot.member.Grade;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000; // 1,000원 할인

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
