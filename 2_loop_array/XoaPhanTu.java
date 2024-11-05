import java.util.Scanner;

public class XoaPhanTu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        int N = sc.nextInt();
        int[] arr = new int[N];
        System.out.print("Nhập các phần tử của mảng:");
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Nhập phần tử cần xóa: ");
        int X = sc.nextInt();
        int index_del = -1;
        for (int i = 0; i < N; i++) {
            if (arr[i] == X) {
                index_del = i;
                break;
            }
        }
        if (index_del == -1) {
            System.out.println("Phần tử " + X + " không có trong mảng.");
        } else {
            for (int i = index_del; i < N - 1; i++) {
                arr[i] = arr[i + 1];
            }
            N--;
            System.out.println("Đã xóa phần tử " + X + " tại vị trí " + index_del);
            System.out.println("Mảng sau khi xóa phần tử: ");
            for (int i = 0; i < N; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
