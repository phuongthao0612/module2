package service;

import entity.Member;

import java.util.List;


public interface IMemberService extends IService<Member> {
    List<Member> searchByName(String name);


}
