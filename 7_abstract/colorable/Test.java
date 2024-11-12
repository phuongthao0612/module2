import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(3);
        shapes[1] = new Square(5);
        shapes[2] = new Rectangle(4, 5);
        for (Shape shape : shapes) {
            System.out.println("Area: " + shape.getArea());
            if (shape instanceof Colorable) {
                ((Colorable) shape).howToColor();
            }
        }
    }
}
