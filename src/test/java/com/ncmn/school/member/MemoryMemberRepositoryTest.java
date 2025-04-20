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
        Member member = Member.createMember(
        );
        member.setName("주언");

        //when
        repository.save(member);
        Optional<Member> foundMember = repository.findByName("주언");

        assertThat(foundMember).isPresent();
        assertThat(foundMember.get()).isEqualTo(member);

    }


}