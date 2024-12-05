package view;


import java.util.Scanner;

import static view.MenuBook.menuBook;
import static view.MenuMember.menuMember;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Quản lý thư viện sách");
            System.out.println("1. Sách");
            System.out.println("2. Độc giả");
            System.out.println("3. Phiếu mượn");
            System.out.println("4. Thoát");
            System.out.println("Nhập lựa chọn: ");
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                continue;
            }
            switch (choice) {
                case 1:
                    menuBook();
                    break;
                case 2:
                    menuMember();
                    break;
                case 3:
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
