package service;

import entity.Member;

import java.util.List;

public interface IMemberService extends IService<Member> {
    void update(int id, Member member);

    List<Member> searchByName(String name);



}
