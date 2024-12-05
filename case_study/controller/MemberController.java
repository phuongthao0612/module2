package controller;

import entity.Member;
import service.IMemberService;
import service.impl.MemberService;


import java.util.List;

public class MemberController {
    private IMemberService memberService = new MemberService();

    public void add(Member member) {
        memberService.add(member);
    }

    public Member findById(int id) {
        return memberService.findById(id);
    }

    public void remove(int id) {
        Member memberToRemove = findById(id);
        if (memberToRemove != null) {
            memberService.remove(id);
        }
        else {
            System.out.println("Không tìm thấy độc giả với ID: " + id);
        }
    }

    public List<Member> getAll() {
        return memberService.getAll();
    }

    public List<Member> searchByName(String name) {
        return memberService.searchByName(name);
    }

}

