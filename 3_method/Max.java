import java.util.Scanner;

public class Max {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Số dòng của ma trận: ");
        int rows = sc.nextInt();
        System.out.print("Số cột của ma trận: ");
        int cols = sc.nextInt();
        double[][] matrix = new double[rows][cols];
        System.out.print("Nhập các phần tử cho ma trận: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextDouble();
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
