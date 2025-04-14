package com.ncmn.school.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearLocalData();
    }

    @Test
    void save() {
        //give
        Member member = new Member(
                "주언",
                "010-1234-5678",
                "jueon@test.email",
                "2000-01-01",
                "서울시 강남구",
                "서울교회",
                "엔지니어",
                LocalDateTime.now()
        );
        member.setName("주언");

        //when
        repository.save(member);
        Optional<Member> foundMember = repository.findByName("주언");

        assertThat(foundMember).isPresent();
        assertThat(foundMember.get()).isEqualTo(member);

    }


}