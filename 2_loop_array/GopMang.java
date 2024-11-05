import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        int N1 = sc.nextInt();
        int[] arr1 = new int[N1];
        System.out.print("Nhập các phần tử của mảng:");
        for (int i = 0; i < N1; i++) {
            arr1[i] = sc.nextInt();
        }
        System.out.print("Nhập số phần tử của mảng: ");
        int N2 = sc.nextInt();
        int[] arr2 = new int[N2];
        System.out.print("Nhập các phần tử của mảng:");
        for (int i = 0; i < N2; i++) {
            arr2[i] = sc.nextInt();
        }
        int[] arr3 = new int[N1 + N2];
        for (int i = 0; i < N1; i++) {
            arr3[i] = arr1[i];
        }
        for (int i = 0; i < N2; i++) {
            arr3[N1 + i] = arr2[i];
        }
        System.out.println("Mảng mới: ");
        for (int i = 0; i < N1 + N2; i++) {
            System.out.print(arr3[i] + " ");
        }
    }
}
