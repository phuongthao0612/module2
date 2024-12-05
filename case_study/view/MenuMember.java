package view;

import controller.MemberController;

import java.util.Scanner;

public class MenuMember {
    public static void menuMember(){
        Scanner scanner = new Scanner(System.in);
        MemberController memberController = new MemberController();
        while(true){
            System.out.println("\nQuản lý độc giả:");
            System.out.println("1. Thêm độc giả");
            System.out.println("2. Xóa độc giả");
            System.out.println("3. Sửa thông tin độc giả");
            System.out.println("4. Hiển thị danh sách độc giả");
            System.out.println("5. Tìm kiếm độc giả");
            System.out.println("6. Trở lại");
            System.out.println("Nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch(choice){
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


            }



        }

    }
}
