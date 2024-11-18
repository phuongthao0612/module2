public class Test {
    public static void main(String[] args) {
        String string = "Able was I ere I saw Elba";
        boolean result = Palindrome.isPalindrome(string);
        if (result) {
            System.out.println(string + " is a palindrome");
        } else {
            System.out.println(string + " is not a palindrome");
        }
    }
}
