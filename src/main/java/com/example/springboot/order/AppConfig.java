package com.example.springboot.order;

import com.example.springboot.discount.DiscountPolicy;
import com.example.springboot.discount.FixDiscountPolicy;
import com.example.springboot.member.*;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}
