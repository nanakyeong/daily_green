package com.example.springboot.discount;

import com.example.springboot.member.Member;

public interface DiscountPolicy {

    //return 할인 대상 금액
    int discount(Member member, int price);
}
