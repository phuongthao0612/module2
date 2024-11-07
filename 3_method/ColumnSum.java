import java.util.Scanner;

public class ColumnSum {
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
                System.out.println("Nhập vào số nguyên dương.");
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
                System.out.println("Nhập vào số dương.");
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
        int column = -1;
        while (column < 1 || column > cols) {
            System.out.print("Nhập số cột muốn tính tổng: ");
            if (sc.hasNextInt()) {
                column = sc.nextInt();
                if (column < 1 || column > cols) {
                    System.out.println("Cột không hợp lệ. Vui lòng nhập lại.");
                }
            } else {
                System.out.println("Nhập vào phải là số nguyên.");
                sc.next();
            }
        }
        double sum = sumValue(matrix, rows, column);
        System.out.println("Tổng của cột " + column + " trong ma trận là: " + sum);
    }

    public static double sumValue(double[][] matrix, int rows, int column) {
        double colSum = 0;
        for (int i = 0; i < rows; i++) {
            colSum += matrix[i][column - 1];
        }
        return colSum;
    }
}
