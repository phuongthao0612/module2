public class ClassExampleTest {
    private static ClassExample classExample;
    public static final String[] validClass = new String[]{"C0223G", "A0323K"};
    public static final String[] invalidClass = new String[]{"M0318G", "P0323A"};

    public static void main(String[] args) {
        classExample = new ClassExample();
        for (String className : validClass) {
            boolean isValid = classExample.validate(className);
            System.out.println("Class is " + className + " is valid: " + isValid);
        }
        for (String className : invalidClass) {
            boolean isValid = classExample.validate(className);
            System.out.println("Class is " + className + " is valid: " + isValid);
        }
    }
}
