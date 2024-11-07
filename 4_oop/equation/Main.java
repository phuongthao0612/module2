import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = getNumber(sc, "Enter the first number: ");
        double b = getNumber(sc, "Enter the second number: ");
        double c = getNumber(sc, "Enter the third number: ");
        QuadraticEquation equation = new QuadraticEquation(a, b, c);
        equation.result();
    }

    private static double getNumber(Scanner sc, String message) {
        double number;
        while (true) {
            System.out.print(message);
            if (sc.hasNextDouble()) {
                number = sc.nextDouble();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.next();
            }
        }
        return number;
    }
}
