import java.util.LinkedList;
import java.util.Queue;

public class Palindrome {
    public static boolean isPalindrome(String str) {
        str = str.toLowerCase();
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            queue.add(str.charAt(i));
        }
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (queue.poll() != str.charAt(end)) {
                return false;
            }
            end--;
        }
        return true;
    }
}
