package com.ncmn.school.member;

import java.time.LocalDateTime;
import java.util.List;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member1 = new Member(
                "kimjueon",
                "12222",
                "test@email",
                "1999-01-19",
                "서울 관악구",
                "대덕교회",
                "개발자",
                LocalDateTime.now()
        );
        Member member2 = new Member(
                "parkjunho",
                "13333",
                "example@email",
                "2000-02-15",
                "서울 송파구",
                "은혜교회",
                "디자이너",
                LocalDateTime.now()
        );

        // 회원 저장
        memberService.join(member1);
        memberService.join(member2);

        // 특정 회원 조회 (findbyName)
        Member foundMember = memberService.findbyName("kimjueon").get();
        System.out.println("조회된 회원: " + foundMember);

        // 전체 회원 조회 및 출력
        List<Member> allMembers = memberService.findAll();
        System.out.println("전체 회원 목록:" + allMembers.size());
        for (Member member : allMembers) {
            System.out.println(member);
            System.out.println(allMembers);
        }
    }
}