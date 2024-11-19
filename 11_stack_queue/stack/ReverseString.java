import java.util.Stack;

public class ReverseString {
    public static String reverse(String str) {
        Stack<String> wStack = new Stack<>();
        String[] words = str.split(" ");
        for (String word : words) {
            wStack.push(word);
        }
        StringBuilder reversed = new StringBuilder();
        while (!wStack.isEmpty()) {
            reversed.append(wStack.pop()).append(" ");
        }
        return reversed.toString().trim();
    }
    public static void main(String[] args) {
        String str = "he ha hi";
        System.out.println("Chuỗi ban đầu: " + str);
        System.out.println("Chuỗi sau khi đảo: " + ReverseString.reverse(str));
    }
}
