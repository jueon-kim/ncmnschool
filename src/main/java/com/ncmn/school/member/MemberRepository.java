package com.ncmn.school.member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 회원 저장 (Create & Update)

    Optional<Member> findByName(String name); // 이름으로 회원 조회 (Read)
    Optional<Member> findByPhone(Number phone); // 전화번호로 회원 조회 (Read)
    Optional<Member> findByEmail(String email); // 이메일로 회원 조회 (Read)

    Optional<Member> findByBirthday(String birthday); // 생년월일로 회원 목록 조회 (Read)
    Optional<Member> findByChurch(String church); // 교회로 회원 목록 조회 (Read)
    Optional<Member> findByJob(String job); // 직업으로 회원 목록 조회 (Read)
    Optional<Member> findByAddressContaining(String keyword); // 주소에 특정 키워드를 포함하는 회원 목록 조회 (Read)
    List <Member> findAll(); // 모든 회원 조회 (Read)

}