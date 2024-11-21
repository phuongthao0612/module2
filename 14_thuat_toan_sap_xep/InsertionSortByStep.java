import java.util.Scanner;

public class InsertionSortByStep {
    public static void insertionSortByStep(int[] list) {
        boolean needNextPass = true;
        int pos;
        int x;
        for (int i = 1; i < list.length; i++) {
            x = list[i];
            pos = i;
            needNextPass = false;
            while (pos > 0 && x < list[pos - 1]) {
                list[pos] = list[pos - 1];
                pos--;
                needNextPass = true;
            }
            list[pos] = x;
            System.out.print("List after the  " + i + "' sort: ");
            for (int j = 0; j < list.length; j++) {
                System.out.print(list[j] + "\t");
            }
            System.out.println();
            if (needNextPass == false) {
                System.out.println("Array may be sorted and next pass not needed");
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = 0;
        while (true) {
            try {
                size = Integer.parseInt(scanner.nextLine());
                if (size <= 0) {
                    System.out.println("Size must be a positive integer.");
                } else break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
        int[] list = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < list.length; i++) {
            while (true) {
                try {
                    System.out.print("Element " + (i + 1) + ": ");
                    list[i] = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter an integer.");
                }
            }
        }
        insertionSortByStep(list);
    }
}
