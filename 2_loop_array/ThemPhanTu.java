import java.util.Scanner;

public class ThemPhanTu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        int N = sc.nextInt();
        int[] arr = new int[N];
        System.out.print("Nhập các phần tử của mảng:");
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Nhập phần tử cần thêm: ");
        int X = sc.nextInt();
        System.out.print("Nhập vị trí cần thêm: ");
        int index = sc.nextInt();
        if (index < 0 || index > N) {
            System.out.println("Vị trí không hợp lệ");
        } else {
            int[] newArr = new int[N + 1];
            for (int i = 0; i < index; i++) {
                newArr[i] = arr[i];
            }
            newArr[index] = X;
            for (int i = index + 1; i < newArr.length; i++) {
                newArr[i] = arr[i - 1];
            }
            arr = newArr;
            System.out.println("Mảng sau khi thêm phần tử: ");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
