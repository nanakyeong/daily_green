package com.example.springboot;

import com.example.springboot.member.Grade;
import com.example.springboot.member.Member;
import com.example.springboot.member.MemberService;
import com.example.springboot.member.MemberServiceImpl;
import com.example.springboot.order.AppConfig;
import com.example.springboot.order.Order;
import com.example.springboot.order.OrderService;
import com.example.springboot.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order =" + order);
    }
}
