package controller;

import entity.Book;
import service.IBookService;
import service.impl.BookService;

import java.util.List;


public class BookController {
    private IBookService bookService = new BookService();

    public void add(Book book) {
        bookService.add(book);
    }

    public void remove(int id) {
        Book bookToRemove = findById(id);
        if (bookToRemove != null) {
            bookService.remove(id);
        } else {
            System.out.println("Không tìm thấy sách với ID: " + id);
        }
    }

    public Book findById(int id) {
        return bookService.findById(id);
    }

    public void updateBook(int id, String title, String author, String category, int stockQuantity, String status) {
        Book book = new Book(id, title, author, category, stockQuantity, status);
        bookService.update(id, book);
    }

    public List<Book> getAll() {
        return bookService.getAll();
    }

    public List<Book> searchByTitle(String title) {
        return bookService.searchByTitle(title);
    }

    public List<Book> searchByAuthor(String author) {
        return bookService.searchByAuthor(author);
    }

    public List<Book> searchByCategory(String category) {
        return bookService.searchByCategory(category);
    }
}
