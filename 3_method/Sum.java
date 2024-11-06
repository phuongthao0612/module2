import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Số dòng của ma trận: ");
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        System.out.print("Nhập các phần tử của ma trận: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
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
