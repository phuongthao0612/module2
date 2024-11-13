public class Square extends Shape implements Resizeable {
    private double side;

    public Square() {

    }

    public Square(double side) {
        this.side = side;
    }

    public Square(double side, String color, boolean filled) {
        super(color, filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getArea() {
        return side * side;
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of"
                + super.toString()
                + ", getArea="
                + getArea();
    }

    @Override
    public void resize(double percent) {
        this.side *= (1 + percent / 100);
    }
}
