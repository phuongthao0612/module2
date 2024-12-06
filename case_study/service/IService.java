package service;


import java.util.List;

public interface IService<E> {
    void add(E e);

    void remove(int id);

    E findById(int id);

    List<E> getAll();



}
