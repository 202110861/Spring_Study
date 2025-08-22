package com.example.test_spring.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{
    //실제 할당하는 부분이 구현체이기 때문에 구현체에 의존하고 있음. DIP 위반
    private final MemberRepository memberRepository;

    @Autowired
    //의존관계를 자동으로 주입.  ac.getbean(MemberRepository.class) 코드가 자동으로 있는거
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
