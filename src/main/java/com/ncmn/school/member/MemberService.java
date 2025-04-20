package com.ncmn.school.member;

import java.util.List;
import java.util.Optional;

//가입과 조회
public interface MemberService {

        Optional<Member> join(Member member);
        List<Member> findAll();
}
