import java.util.Scanner;

public class ColumnSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Số dòng của ma trận: ");
        int rows = sc.nextInt();
        System.out.print("Số cột của ma trận: ");
        int cols = sc.nextInt();
        double[][] matrix = new double[rows][cols];
        System.out.println("Nhập các phần tử cho ma trận: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextDouble();
            }
        }
        System.out.print("Nhập số cột muốn tính tổng: ");
        int column = sc.nextInt();
        if (column < 1 || column > cols) {
            System.out.print("Không hợp lệ");
        } else {
            double sum = sumValue(matrix, rows, column);
            System.out.println("Tổng của cột " + column + " trong ma trận là: " + sum);
        }
    }

    public static double sumValue(double[][] matrix, int rows, int column) {
        double colSum = 0;
        for (int i = 0; i < rows; i++) {
            colSum += matrix[i][column - 1];
        }
        return colSum;
    }
}
