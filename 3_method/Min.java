import java.util.Scanner;

public class Min {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int SIZE = -1;
        while(SIZE <= 0){
            System.out.print("Nhập số phần tử của mảng: ");
            if (sc.hasNextInt()){
                SIZE = sc.nextInt();
                if (SIZE <= 0){
                    System.out.println("Số phần tử mảng phải là số nguyên dương.");
                }
            }
            else {
                System.out.println("Nhập vào phải là số nguyên.");
                sc.next();
            }
        }
        int[] arr = new int[SIZE];
        System.out.println("Nhập các phần tử của mảng: ");
        for (int i = 0; i < SIZE; i++) {
            while (true){
                if (sc.hasNextInt()){
                    arr[i] = sc.nextInt();
                    break;
                }
                else {
                    System.out.println("Nhập vào phải là số nguyên.");
                    sc.next();
                }
            }
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
