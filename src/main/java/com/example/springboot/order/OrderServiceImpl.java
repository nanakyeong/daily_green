package com.example.springboot.order;

import com.example.springboot.discount.DiscountPolicy;
import com.example.springboot.member.Member;
import com.example.springboot.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //단일 책임 원칙 잘 지킴
    // 왜냐, 할인 값이 바뀌어도 할인 쪽만 바꾸게 설계 되어있으니까
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
