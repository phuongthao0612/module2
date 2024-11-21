import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số phần tử của mảng: ");
        int number = 0;
        while (true) {
            try {
                number = Integer.parseInt(sc.nextLine());
                if (number <= 0) {
                    System.out.println("Số phần tử của mảng phải là số dương.");
                }
                else break;
            } catch (NumberFormatException e) {
                System.out.println("Số phần tử của mảng phải là số.");
            }
        }
        int[] arr = new int[number];
        System.out.println("Nhập các giá trị cho mảng: ");
        for (int i = 0; i < number; i++) {
            while (true) {
                try {
                    System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
                    arr[i] = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Giá trị phải là số nguyên.");
                }
            }
        }
        Arrays.sort(arr);
        System.out.println("Mảng sau khi được sắp xếp: " + Arrays.toString(arr));
        System.out.println("Nhập giá trị cần tìm: ");
        int value = 0;
        while (true) {
            try {
                value = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Giá trị tìm kiếm phải là số nguyên.");
            }
        }

        int result = BinarySearch.binarySearch(arr, 0, number - 1, value);
        if (result == -1) {
            System.out.println("Không tìm thấy phần tử trong mảng.");
        } else {
            System.out.println("Phần tử " + value + " được tìm thấy tại " + result);
        }
    }
}