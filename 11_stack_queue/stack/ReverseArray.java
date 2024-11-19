import java.util.Stack;

public class ReverseArray {
    public static void reverse(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
    }

    public static void printArray(int[] arr) {
        for (int number : arr) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Mảng ban đầu: ");
        printArray(arr);
        System.out.println();
        reverse(arr);
        System.out.println("Mảng sau khi đảo ngược");
        printArray(arr);
    }
}
