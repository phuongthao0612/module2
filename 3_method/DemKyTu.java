import java.util.Scanner;

public class DemKyTu {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String str = sc.nextLine();
        System.out.print("Nhập ký tự: ");
        char kytu = sc.next().charAt(0);
        int count = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == kytu){
                count++;
            }
        }
        System.out.println("Số lần xuất hiện của ký tự '" +  kytu  + "' trong chuỗi = " +count);
    }
}
