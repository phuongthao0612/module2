package service.impl;

import entity.Member;
import repository.MemberRepository;
import service.IMemberService;

import java.util.List;

public class MemberService implements IMemberService {

    private MemberRepository memberRepository = new MemberRepository();

    @Override
    public void add(Member member) {
        memberRepository.add(member);
    }

    @Override
    public void remove(int id) {
        memberRepository.remove(id);
    }

    @Override
    public void update(int id, Member member) {
        memberRepository.update(member);
    }

    @Override
    public Member findById(int id) {
        return memberRepository.findById(id);
    }

    @Override
    public List<Member> getAll() {
        return memberRepository.getAll();
    }

    @Override
    public List<Member> searchByName(String name) {
        return memberRepository.searchByName(name);
    }
}
