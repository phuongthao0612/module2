import java.util.Scanner;

public class Currency {
    public static void main(String[] args) {
        double usd;
        Scanner sc = new Scanner(System.in);
        System.out.print("Moi ban nhap Usd:");
        usd = sc.nextDouble();
        if (usd > 0) {
            double convert = usd * 23000;
            System.out.print("Vnd = " + convert);
        } else {
            System.out.print("Nhap Usd lon hon 0");
        }
    }
}
