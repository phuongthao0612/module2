package repository;

import entity.Book;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class BookRepository {
    public List<Book> getAll() {
        File file = new File("src/csv/book.csv");
        List<Book> books = new LinkedList<>();
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                Book book = new Book(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        data[3],
                        Integer.parseInt(data[4]),
                        data[5]
                );
                books.add(book);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file " + "src/csv/book.csv");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file " + "src/csv/book.csv");
        }
        return books;
    }

    private void writeFile(List<Book> books, boolean append) {
        File file = new File("src/csv/book.csv");
        try (FileWriter fileWriter = new FileWriter(file, append);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Book book : books) {
                bufferedWriter.write(book.getId() + "," + book.getTitle() + "," + book.getAuthor() + ","
                        + book.getCategory() + "," + book.getStockQuantity() + "," + book.getStatus());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi dữ liệu");
        }
    }

    public void add(Book book) {
        List<Book> books = getAll();
        books.add(book);
        writeFile(books, true);
    }

    public Book findById(int id) {
        List<Book> books = getAll();
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public void remove(int id) {
        List<Book> books = getAll();
        books.removeIf(book -> book.getId() == id);
        writeFile(books, false);
    }

    public void update(Book updatedBook) {
        List<Book> books = getAll();
        for (int i = 0; i < books.size(); i++) {
            Book currentBook = books.get(i);
            if (currentBook.getId() == updatedBook.getId()) {
                books.set(i, updatedBook);
                break;
            }
        }
        writeFile(books, false);
    }

    public List<Book> searchByTitle(String title) {
        List<Book> books = getAll();
        List<Book> result = new LinkedList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> books = getAll();
        List<Book> result = new LinkedList<>();
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchByCategory(String category) {
        List<Book> books = getAll();
        List<Book> result = new LinkedList<>();
        for (Book book : books) {
            if (book.getCategory().toLowerCase().contains(category.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }
}

