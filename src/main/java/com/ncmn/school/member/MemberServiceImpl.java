package com.ncmn.school.member;

import java.util.HashMap;
import java.util.*;
import java.util.Map;
import java.util.Optional;

public class MemberServiceImpl implements MemberService {
    private final Map<String, Member> memberStore = new HashMap<>();

    @Override
    public void join(Member member) {
        memberStore.put(member.getName(), member); // 이름을 key로 저장
    }

    @Override
    public Optional<Member> findbyName(String name) {
        return Optional.ofNullable(memberStore.get(name)); // Optional 반환
    }

    @Override
    public List<Member> findAll() {
        return new  ArrayList<>(memberStore.values());
    }
}