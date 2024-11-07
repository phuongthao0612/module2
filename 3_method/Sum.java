import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = -1;
        while (n <= 0) {
            System.out.print("Nhập số dòng (và cột) của ma trận: ");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                if (n <= 0) {
                    System.out.println("Số dòng (và cột) phải là số nguyên dương.");
                }
            } else {
                System.out.println("Nhập vào phải là số nguyên.");
                sc.next();
            }
        }
        int[][] matrix = new int[n][n];
        System.out.println("Nhập các phần tử của ma trận: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                while (true) {
                    if (sc.hasNextInt()) {
                        matrix[i][j] = sc.nextInt();
                        break;
                    } else {
                        System.out.println("Nhập vào phải là số nguyên.");
                        sc.next();
                    }
                }
            }
        }
        int sum = sumValue(matrix);
        System.out.println("Tổng các số ở đường chéo chính của ma trận = " + sum);
    }

    public static int sumValue(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
}
