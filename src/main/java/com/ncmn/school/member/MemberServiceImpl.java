package com.ncmn.school.member;

import java.util.List;
import java.util.Optional;

public class MemberServiceImpl implements MemberService  {


    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Optional<Member> join(Member member) {
        System.out.println(">>> 서비스에서 회원 저장 시도: " + member.getName());
        memberRepository.save(member); // DB에 회원 저장
        return Optional.of(member); // 빈값 말고 실제 저장된 객체 반환
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

}