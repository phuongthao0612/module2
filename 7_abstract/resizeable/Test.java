import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[5];
        shapes[0] = new Circle(2.0);
        shapes[1] = new Rectangle(3.0, 4.0);
        shapes[2] = new Square(5.0);
        shapes[3] = new Circle(6.0);
        shapes[4] = new Rectangle(7.0, 8.0);
        Random random = new Random();
        for (Shape shape : shapes) {
            System.out.println("Before resizing: " + shape.toString());
            System.out.println("Area before resizing: " + shape.getArea());
            double percent = random.nextDouble() * 100;
            System.out.println("Resizing by " + percent + "%");
            shape.resize(percent);
            System.out.println("After resizing: " + shape.toString());
            System.out.println("Area after resizing: " + shape.getArea());
        }
    }
}
