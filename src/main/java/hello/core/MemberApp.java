package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

// 이 클래스는 순수 자바 코드로만 이루어져 있고, 스프링 관련 내용이 전혀 없다.
public class MemberApp {
    public static void main(String[] args) {

        // MemberServiceImpl을 통해 Member를 생성하고, 조회하는 코드이다.
        MemberService memberService = new MemberServiceImpl();
        Member memver = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memver);

        // 조회를 위해 findMember 메서드를 호출한다.
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + memver.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
