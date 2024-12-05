package view;

import controller.BookController;
import entity.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuBook {
    public static void menuBook() {
        Scanner scanner = new Scanner(System.in);
        BookController bookController = new BookController();
        while (true) {
            System.out.println("\nQuản lý sách:");
            System.out.println("1. Thêm sách");
            System.out.println("2. Xóa sách");
            System.out.println("3. Sửa thông tin sách");
            System.out.println("4. Hiển thị danh sách sách");
            System.out.println("5. Tìm kiếm sách");
            System.out.println("6. Trở lại");
            System.out.print("Nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Thêm sách: ");
                    bookController.add(inputBook(scanner));
                    System.out.println("Thêm mới thành công");
                    break;
                case 2:
                    System.out.println("Xóa sách: ");
                    deleteBook(scanner, bookController);
                    break;
                case 3:
                    System.out.println("Sửa thông tin sách: ");
                    updateBook(scanner, bookController);
                    break;
                case 4:
                    System.out.println("Hiển thị danh sách sách: ");
                    displayBooks(bookController);
                    break;
                case 5:
                    System.out.println("Tìm kiếm sách: ");
                    searchBooks(scanner, bookController);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static Book inputBook(Scanner scanner) {
        System.out.println("Nhập ID sách: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên sách: ");
        String title = scanner.nextLine();
        System.out.println("Nhập tên tác giả: ");
        String author = scanner.nextLine();
        System.out.println("Nhập thể loại sách: ");
        String category = scanner.nextLine();
        System.out.println("Nhập số lượng tồn kho: ");
        int stockQuantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập trạng thái sách: ");
        String status = scanner.nextLine();
        return new Book(id, title, author, category, stockQuantity, status);
    }

    private static void deleteBook(Scanner scanner, BookController bookController) {
        System.out.print("Nhập ID cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        Book book = bookController.findById(id);
        if (book == null) {
            System.out.println("Không tìm thấy sách có id là: " + id);
        } else {
            System.out.println("Thông tin sách cần xóa: " + book);
            System.out.println("Bạn có chắc muốn xóa sách này không?");
            System.out.println("Lưu ý: Hành động này không thể hoàn tác.");
            System.out.println("Bấm y để xác nhận. Bấm phím bất kỳ để hủy.");
            char confirm = scanner.nextLine().charAt(0);
            if (confirm == 'y') {
                bookController.remove(id);
                System.out.println("Xóa sách thành công.");
            } else {
                System.out.println("Hủy xóa sách.");
            }
        }
    }

    private static void updateBook(Scanner scanner, BookController bookController) {
        System.out.println("Nhập ID sách cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        Book book = bookController.findById(id);
        if (book != null) {
            System.out.println("Thông tin sách hiện tại: " + book);
            System.out.println("Nhập tên sách mới (hoặc giữ nguyên):");
            String title = scanner.nextLine();
            if (!title.isEmpty()) {
                book.setTitle(title);
            }
            System.out.println("Nhập tên tác giả mới (hoặc giữ nguyên):");
            String author = scanner.nextLine();
            if (!author.isEmpty()) {
                book.setAuthor(author);
            }
            System.out.println("Nhập thể loại sách mới (hoặc giữ nguyên):");
            String category = scanner.nextLine();
            if (!category.isEmpty()) {
                book.setCategory(category);
            }
            System.out.println("Nhập số lượng tồn kho mới (hoặc giữ nguyên):");
            String stockQuantity = scanner.nextLine();
            if (!stockQuantity.isEmpty()) {
                try {
                    book.setStockQuantity(Integer.parseInt(stockQuantity));
                } catch (NumberFormatException e) {
                    System.out.println("Số lượng tồn kho không hợp lệ.");
                }
            }
            System.out.println("Nhập trạng thái sách mới (hoặc giữ nguyên):");
            String status = scanner.nextLine();
            if (!status.isEmpty()) {
                book.setStatus(status);
            }
            bookController.updateBook(id, book.getTitle(), book.getAuthor(),
                    book.getCategory(), book.getStockQuantity(), book.getStatus());
            System.out.println("Sửa thông tin sách thành công!");
        } else {
            System.out.println("Không tìm thấy sách với ID: " + id);
        }
    }

    private static void displayBooks(BookController bookController) {
        List<Book> books = bookController.getAll();
        if (books.isEmpty()) {
            System.out.println("Không có sách nào.");
        } else {
            System.out.println("Danh sách sách hiện có:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private static void searchBooks(Scanner scanner, BookController bookController) {
        while (true) {
            System.out.println("Chọn cách tìm kiếm sách: ");
            System.out.println("1. Tìm theo tên sách");
            System.out.println("2. Tìm theo tác giả");
            System.out.println("3. Tìm theo thể loại");
            System.out.print("Nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            List<Book> foundBooks = new ArrayList<>();
            switch (choice) {
                case 1:
                    System.out.print("Nhập tên sách cần tìm: ");
                    String title = scanner.nextLine();
                    foundBooks = bookController.searchByTitle(title);
                    break;
                case 2:
                    System.out.print("Nhập tên tác giả cần tìm: ");
                    String author = scanner.nextLine();
                    foundBooks = bookController.searchByAuthor(author);
                    break;
                case 3:
                    System.out.print("Nhập thể loại cần tìm: ");
                    String category = scanner.nextLine();
                    foundBooks = bookController.searchByCategory(category);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    return;
            }
            if (foundBooks.isEmpty()) {
                System.out.println("Không tìm thấy sách nào.");
            } else {
                System.out.println("Kết quả tìm kiếm: ");
                for (Book book : foundBooks) {
                    System.out.println(book);
                }
            }
        }
    }
}