package com.ncmn.school.member;


import java.sql.Array;
import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<String, Member> repository = new HashMap<>();

    @Override
    public void save(Member member) {
        repository.put(member.getName(), member);
    }
    @Override
    public Optional<Member> findByName(String name) {
        return Optional.ofNullable(repository.get(name));
    }

    @Override
    public Optional<Member> findByPhone(Number phone) {
        return repository.values().stream()
                .filter(member -> member.getPhone().equals(phone))
                .findFirst();
    }

    @Override
    public Optional<Member> findByEmail(String email) {
        return repository.values().stream()
                .filter(member -> member.getEmail().equals(email))
                .findFirst();

    }

    @Override
    public Optional<Member> findByBirthday(String birthday) {
        return repository.values().stream()
                .filter(member -> member.getBirthday().equals(birthday))
                .findFirst();
    }

    @Override
    public Optional<Member> findByChurch(String church) {
        return repository.values().stream()
                .filter(member -> member.getChurch().equals(church))
                .findFirst();
    }

    @Override
    public Optional<Member> findByJob(String job) {
        return repository.values().stream()
                .filter(member -> member.getJob().equals(job))
                .findFirst();
    }

    @Override
    public Optional<Member> findByAddressContaining(String keyword) {
        return repository.values().stream()
                .filter(member -> member.getAddress().contains(keyword))
                .findFirst();
    }


    @Override
    public List<Member> findAll() {
        return new ArrayList<>(repository.values());
    }


    public void clearLocalData() {
        repository.clear();
    }
}