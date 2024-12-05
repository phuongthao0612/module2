package service.impl;

import entity.Book;
import repository.BookRepository;
import service.IBookService;

import java.util.List;

public class BookService implements IBookService {
    private BookRepository bookRepository = new BookRepository();

    @Override
    public void add(Book book) {
        bookRepository.add(book);
    }

    @Override
    public void remove(int id) {
        bookRepository.remove(id);
    }

    @Override
    public void update(int id, Book book) {
        bookRepository.update(book);
    }


    @Override
    public Book findById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    @Override
    public List<Book> searchByTitle(String title) {
        return bookRepository.searchByTitle(title);
    }

    @Override
    public List<Book> searchByAuthor(String author) {
        return bookRepository.searchByAuthor(author);
    }

    @Override
    public List<Book> searchByCategory(String category) {
        return bookRepository.searchByCategory(category);
    }
}
