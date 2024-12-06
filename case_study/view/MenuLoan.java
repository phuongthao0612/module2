package view;

import controller.LoanController;
import entity.Loan;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MenuLoan {
    public static void menuLoan() {
        Scanner scanner = new Scanner(System.in);
        LoanController loanController = new LoanController();
        while (true) {
            System.out.println("\nQuản lý phiếu mượn: ");
            System.out.println("1. Tạo phiếu mượn sách");
            System.out.println("2. Xóa phiếu mượn sách");
            System.out.println("3. Theo dõi tình trạng mượn sách");
            System.out.println("4. Hiển thị danh sách các phiếu mượn");
            System.out.println("5. Tạo phiếu trả sách");
            System.out.println("6. Trở lại");
            System.out.println("Nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập thông tin phiếu mượn: ");
                    loanController.add(createLoan(scanner));
                    break;
                case 2:
                    System.out.println("Xóa phiếu mượn sách: ");
                    deleteLoan(scanner, loanController);
                    break;
                case 3:
                    System.out.println("Theo dõi tình trạng mượn sách");
                    trackLoan(scanner, loanController);
                    break;
                case 4:
                    System.out.println("Hiển thị danh sách các phiếu mượn");
                    displayLoans(loanController);
                    break;
                case 5:
                    System.out.println("Tạo phiếu trả sách");
                    createReturnTicket(scanner, loanController);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static Loan createLoan(Scanner scanner) {
        System.out.println("Nhập Id phiếu mượn: ");
        int loanId = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập Id sách: ");
        int bookId = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập Id độc giả: ");
        int memberId = Integer.parseInt(scanner.nextLine());
        String datePattern = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$";
        String loanDate = "";
        String returnDate = "";
        while (true) {
            System.out.println("Nhập ngày mượn sách (dd/MM/yyyy): ");
            loanDate = scanner.nextLine();
            if (Pattern.matches(datePattern, loanDate)) {
                break;
            } else {
                System.out.println("Ngày mượn không hợp lệ. Vui lòng nhập lại theo định dạng dd/MM/yyyy.");
            }
        }
        while (true) {
            System.out.println("Nhập ngày trả sách (dd/MM/yyyy): ");
            returnDate = scanner.nextLine();
            if (Pattern.matches(datePattern, returnDate)) {
                break;
            } else {
                System.out.println("Ngày trả không hợp lệ. Vui lòng nhập lại theo định dạng dd/MM/yyyy.");
            }
        }
        return new Loan(loanId, bookId, memberId, loanDate, returnDate);
    }

    private static void deleteLoan(Scanner scanner, LoanController loanController) {
        System.out.println("Nhập ID phiếu mượn cần xóa: ");
        int loanId = Integer.parseInt(scanner.nextLine());
        Loan loan = loanController.findById(loanId);
        if (loan == null) {
            System.out.println("Không tìm thấy phiếu mượn có id là: " + loanId);
        } else {
            System.out.println("Thông tin phiếu mượn cần xóa: " + loan);
            System.out.println("Bạn có chắc muốn xóa phiếu mượn này không?");
            System.out.println("Lưu ý: Hành động này không thể hoàn tác.");
            System.out.println("Bấm y để xác nhận. Bấm phím bất kỳ để hủy.");
            char confirm = scanner.nextLine().charAt(0);
            if (confirm == 'y') {
                loanController.remove(loanId);
                System.out.println("Xóa thành công.");
            } else {
                System.out.println("Hủy xóa phiếu mượn.");
            }
        }
    }

    private static void trackLoan(Scanner scanner, LoanController loanController) {
        System.out.println("Nhập Id phiếu mượn: ");
        int loanId = Integer.parseInt(scanner.nextLine());
        Loan loan = loanController.findById(loanId);
        if (loan != null) {
            if (loan.isReturned()) {
                System.out.println("Tình trạng phiếu mượn: Đã trả");
            } else {
                System.out.println("Tình trạng phiếu mượn: Chưa trả");
            }
        } else {
            System.out.println("Không tìm thấy phiếu mượn với ID " + loanId);
        }
    }

    private static void displayLoans(LoanController loanController) {
        List<Loan> loans = loanController.getAll();
        if (loans.isEmpty()) {
            System.out.println("Không có phiếu mượn nào");
        } else {
            System.out.println("Danh sách phiếu mượn hiện có: ");
            for (Loan loan : loans) {
                System.out.println(loan);
            }
        }
    }

    private static void createReturnTicket(Scanner scanner, LoanController loanController) {
        System.out.println("Nhập thông tin phiếu mượn để tạo phiếu trả: ");
        int loanId = Integer.parseInt(scanner.nextLine());
        Loan loan = loanController.findById(loanId);
        if (loan != null && !loan.isReturned()) {
            System.out.println("Nhập ngày trả sách: ");
            String returnDate = scanner.nextLine();
            loan.setReturnDate(returnDate);
            loan.setReturned(true);
            loanController.updateLoan(loan);
            System.out.println("Phiếu trả đã được tạo!");
        } else {
            System.out.println("Phiếu mượn không hợp lệ hoặc đã trả sách.");
        }
    }
}
