public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println("Circle 1 radius: " + circle.getRadius());
        System.out.println("Circle 1 area: " + circle.getArea());
        Circle circle2 = new Circle(5.0);
        System.out.println("Circle 2 radius: " + circle2.getRadius());
        System.out.println("Circle 2 area: " + circle2.getArea());
    }
}
