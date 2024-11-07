import java.util.Scanner;

public class Max {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = -1;
        int cols = -1;
        while (rows <= 0) {
            System.out.print("Nhập vào số dòng là số nguyên dương: ");
            if (sc.hasNextInt()) {
                rows = sc.nextInt();
                if (rows <= 0) {
                    System.out.println("Số dòng phải là số nguyên dương");
                }
            } else {
                System.out.println("Nhập vào phải là số nguyên.");
                sc.next();
            }
        }
        while (cols <= 0) {
            System.out.print("Nhập vào số cột là số nguyên dương: ");
            if (sc.hasNextInt()) {
                cols = sc.nextInt();
                if (cols <= 0) {
                    System.out.println("Số cột phải là số nguyên dương");
                }
            } else {
                System.out.println("Nhập vào phải là số nguyên.");
                sc.next();
            }
        }
        double[][] matrix = new double[rows][cols];
        System.out.println("Nhập các phần tử cho ma trận: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                while (true) {
                    if (sc.hasNextDouble()) {
                        double value = sc.nextDouble();
                        if (value >= 0) {
                            matrix[i][j] = value;
                            break;
                        } else {
                            System.out.println("Nhập vào số dương.");
                        }
                    } else {
                        System.out.println("Số nhập vào không hợp lệ");
                        sc.next();
                    }
                }
            }
        }
        double max = maxValue(matrix);
        System.out.println("Phần tử lớn nhất trong mảng: " + max);
    }

    public static double maxValue(double[][] matrix) {
        double max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        return max;
    }
}
