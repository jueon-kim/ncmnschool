package com.ncmn.school.member;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.time.LocalDateTime;
import java.util.List;

public class MemberApp {
    public static void main(String[] args) {
        // H2 데이터베이스 연결 설정
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:tcp://localhost/~/test"); // H2 DB URL
        dataSource.setUsername("sa");
        dataSource.setPassword("password");

        // JdbcMemberRepository 생성
        MemberRepository memberRepository = new JdbcMemberRepository(dataSource);


        Member newMember = Member.createMember();
        newMember.setName("kimjueon");
        newMember.setPhone("010-1234-5678");
        newMember.setEmail("kimjueon@example.com");
        newMember.setBirthday("1990-01-01");
        newMember.setAddress("서울");
        newMember.setChurch("교회");
        newMember.setJob("개발자");

        System.out.println(newMember);
    }
}