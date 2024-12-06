package view;

import controller.MemberController;
import entity.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuMember {
    public static void menuMember() {
        Scanner scanner = new Scanner(System.in);
        MemberController memberController = new MemberController();
        while (true) {
            System.out.println("\nQuản lý độc giả: ");
            System.out.println("1. Thêm độc giả");
            System.out.println("2. Xóa độc giả");
            System.out.println("3. Sửa thông tin độc giả");
            System.out.println("4. Hiển thị danh sách độc giả");
            System.out.println("5. Tìm kiếm độc giả");
            System.out.println("6. Trở lại");
            System.out.print("Nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Thêm độc giả: ");
                    memberController.add(inputMember(scanner));
                    System.out.println("Thêm mới thành công");
                    break;
                case 2:
                    System.out.println("Xóa độc giả: ");
                    deleteMember(scanner, memberController);
                    break;
                case 3:
                    System.out.println("Sửa thông tin độc giả: ");
                    updateMember(scanner, memberController);
                    break;
                case 4:
                    System.out.println("Hiển thị danh sách các độc giả: ");
                    displayMembers(memberController);
                    break;
                case 5:
                    System.out.println("Tìm kiếm độc giả: ");
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
        System.out.println("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        return new Member(id, name, address);
    }

    private static void deleteMember(Scanner scanner, MemberController memberController) {
        System.out.print("Nhập ID cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        Member member = memberController.findById(id);
        if (member == null) {
            System.out.println("Không tìm thấy độc giả có id là: " + id);
        } else {
            System.out.println("Thông tin độc giả cần xóa: " + member);
            System.out.println("Bạn có chắc muốn xóa độc giả này không?");
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
            System.out.println("Nhập địa chỉ độc giả (hoặc giữ nguyên): ");
            String address = scanner.nextLine();
            if (!address.isEmpty()) {
                member.setAddress(address);
            }
            memberController.updateMember(id, member.getName(), member.getAddress());
            System.out.println("Sửa thông tin thành công.");
        } else {
            System.out.println("Không tìm thấy độc giả với ID: " + id);
        }
    }

    private static void displayMembers(MemberController memberController) {
        List<Member> members = memberController.getAll();
        if (members.isEmpty()) {
            System.out.println("Không có độc giả nào.");
        } else {
            System.out.println("Danh sách độc giả hiện có: ");
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
