package com.example.test_spring.member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}
