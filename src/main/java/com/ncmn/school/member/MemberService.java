package com.ncmn.school.member;

import java.util.List;
import java.util.Optional;

//가입과 조회
public interface MemberService {

    void join(Member member);
    Optional<Member> findbyName(String name);
    List<Member> findAll(); //전체 회원 조회


}
