package service;

import entity.Book;

import java.util.List;

public interface IService <E> {
    void add(E e);

    void remove(int id);

    void update(int id, E e);

    E findById(int id);

    List<E> getAll();



}
