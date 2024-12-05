package service;

import entity.Book;

import java.util.List;

public interface IBookService extends IService <Book> {
    List<Book> searchByTitle(String title);

    List<Book> searchByAuthor(String author);

    List<Book> searchByCategory(String category);

}
