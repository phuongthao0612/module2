public class PhoneNumberTest {
    private static PhoneNumber phoneNumber;
    public static final String[] validPhoneNumbers = new String[]{"(84)-(0978489648)"};
    public static final String[] invalidPhoneNumbers = new String[]{"(84)-(09)", "(a8)-(22222222)", "(84)-(22b22222)", "(84)-(9978489648)"};

    public static void main(String[] args) {
        phoneNumber = new PhoneNumber();
        for (String number : validPhoneNumbers) {
            boolean isValid = phoneNumber.validate(number);
            System.out.println(isValid);
        }
        for (String number : invalidPhoneNumbers) {
            boolean isValid = phoneNumber.validate(number);
            System.out.println(isValid);
        }
    }
}
