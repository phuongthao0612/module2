package view;

import controller.MemberController;
import entity.Book;
import entity.Member;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MenuMember {
    public static void menuMember() {
        Scanner scanner = new Scanner(System.in);
        MemberController memberController = new MemberController();
        while (true) {
            System.out.println("\nQuản lý độc giả:");
            System.out.println("1. Thêm độc giả");
            System.out.println("2. Xóa độc giả");
            System.out.println("3. Sửa thông tin độc giả");
            System.out.println("4. Hiển thị danh sách độc giả");
            System.out.println("5. Tìm kiếm độc giả");
            System.out.println("6. Trở lại");
            System.out.println("Nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Thêm độc giả: ");
                    memberController.add(inputMember(scanner));
                    System.out.println("Thêm mới thành công");
                    break;
                case 2:
                    System.out.println("Xóa độc giả");
                    deleteMember(scanner, memberController);
                    break;
                case 3:
                    System.out.println("Sửa thông tin độc giả");
                    updateMember(scanner, memberController);
                    break;
                case 4:
                    System.out.println("Hiển thị danh sách độc giả");
                    displayMembers(memberController);
                    break;
                case 5:
                    System.out.println("Tìm kiếm độc giả");
                    searchMembers(scanner, memberController);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static Member inputMember(Scanner scanner) {
        System.out.println("Nhập ID độc giả: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên độc giả: ");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày sinh độc giả (định dạng dd/MM/yyyy): ");
        Date birthDate = null;
        String date = "";
        while (birthDate == null) {
            System.out.println("Nhập ngày sinh độc giả (định dạng dd/MM/yyyy): ");
            date = scanner.nextLine();
            if (date.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$")) {
                try {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    birthDate = formatter.parse(date);
                    System.out.println("Ngày sinh của độc giả là: " + birthDate);
                } catch (Exception e) {
                    System.out.println("Định dạng ngày không hợp lệ. Vui lòng nhập lại.");
                }
            } else {
                System.out.println("Ngày sinh không hợp lệ. Vui lòng nhập lại.");
            }
        }
        System.out.println("Nhập địa chỉ độc giả: ");
        String address = scanner.nextLine();
        String phone = "";
        while (true) {
            System.out.println("Nhập thông tin liên hệ độc giả: ");
            phone = scanner.nextLine();
            if (phone.matches("^0\\d{9}$")) {
                break;
            } else {
                System.out.println("Số điện thoại không hợp lệ. Vui lòng nhập lại.");
            }
        }
        return new Member(id, name, birthDate, address, phone);
    }

    private static void deleteMember(Scanner scanner, MemberController memberController) {
        System.out.print("Nhập ID cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        Member member = memberController.findById(id);
        if (member != null) {
            System.out.println("Không tìm thấy thông tin có id là: " + id);
        } else {
            System.out.println("Thông tin độc giả cần xóa: " + member);
            System.out.println("Bạn có chắc muốn xóa sách này không?");
            System.out.println("Lưu ý: Hành động này không thể hoàn tác.");
            System.out.println("Bấm y để xác nhận. Bấm phím bất kỳ để hủy.");
            char confirm = scanner.nextLine().charAt(0);
            if (confirm == 'y') {
                memberController.remove(id);
                System.out.println("Xóa thành công.");
            } else {
                System.out.println("Hủy xóa độc giả.");
            }
        }
    }

    private static void updateMember(Scanner scanner, MemberController memberController) {
        System.out.println("Nhập ID độc giả cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        Member member = memberController.findById(id);
        if (member != null) {
            System.out.println("Thông tin độc giả hiện tại: " + member);
            System.out.println("Nhập tên độc giả mới (hoặc giữ nguyên): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                member.setName(name);
            }

    }

    private static void displayMembers(MemberController memberController) {
        List<Member> members = memberController.getAll();
        if (members.isEmpty()) {
            System.out.println("Không có thông tin.");
        } else {
            System.out.println("Danh sách hiện có: ");
            for (Member member : members) {
                System.out.println(member);
            }
        }
    }

    private static void searchMembers(Scanner scanner, MemberController memberController) {
        List<Member> foundMembers = new ArrayList<>();
        System.out.println("Nhập tên độc giả cần tìm: ");
        String name = scanner.nextLine();
        foundMembers = memberController.searchByName(name);
        if (foundMembers.isEmpty()) {
            System.out.println("Không tìm thấy độc giả với tên" + name);
        } else {
            for (Member member : foundMembers) {
                System.out.println(member);
            }
        }

    }


}
