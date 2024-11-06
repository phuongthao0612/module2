import java.util.Scanner;

public class Min {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        int SIZE = sc.nextInt();
        int[] arr = new int[SIZE];
        System.out.print("Nhập các phần tử của mảng: ");
        for (int i = 0; i < SIZE; i++) {
            arr[i] = sc.nextInt();
        }
        int min = minValue(arr);
        System.out.println("Giá trị nhỏ nhất trong mảng:" + min);

    }
    public static int minValue(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
