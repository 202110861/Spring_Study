package com.example.test_spring.member;

public interface MemberService {

    void join(Member member);
    Member findMember(Long memberId);

    MemberRepository getMemberRepository();
}

