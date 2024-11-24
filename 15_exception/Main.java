import java.util.Scanner;

public class Main {
    public static int getSide() {
        Scanner scanner = new Scanner(System.in);
        int side = 0;
        while (true) {
            System.out.println("Nhập cạnh: ");
            try {
                side = Integer.parseInt(scanner.nextLine());
                if (side <= 0) {
                    System.out.println("Cạnh phải là số dương.");
                } else break;
            } catch (NumberFormatException e) {
                System.out.println("Cạnh phải là số.");
            }
        }
        return side;
    }

    public static void main(String[] args) {
        try {
            System.out.print("Nhập cạnh a: ");
            int a = getSide();
            System.out.print("Nhập cạnh b: ");
            int b = getSide();
            System.out.print("Nhập cạnh c: ");
            int c = getSide();
            Triangle.checkTriangle(a, b, c);
            System.out.println("Đây là một tam giác hợp lệ!");
        } catch (IllegalTriangleException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
