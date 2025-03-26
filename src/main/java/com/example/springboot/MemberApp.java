package com.example.springboot;

import com.example.springboot.member.Grade;
import com.example.springboot.member.Member;
import com.example.springboot.member.MemberService;
import com.example.springboot.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
