import java.util.Scanner;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;
    public QuadraticEquation(){
    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getDiscriminant() {
        return b * b - 4 * a * c;
    }

    public double getRoot1() {
        double delta = getDiscriminant();
        return (-b + Math.sqrt(delta)) / (2 * a);
    }

    public double getRoot2() {
        double delta = getDiscriminant();
        return (-b - Math.sqrt(delta)) / (2 * a);
    }

    public void result() {
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("The quadratic equation has infinite solution.");
                } else {
                    System.out.println("The quadratic equation has no solution.");
                }
            } else {
                double x = -c / b;
                System.out.println("The equation has one solution: " +x);
            }
        } else {
            double delta = getDiscriminant();
            if (delta > 0) {
                double x1 = getRoot1();
                double x2 = getRoot2();
                System.out.println("The quadratic equation has two solutions: ");
                System.out.println("Solution 1: " + x1);
                System.out.println("Solution 2: " + x2);
            } else if (delta == 0) {
                double x = -b / (2 * a);
                System.out.println("The quadratic equation has solution: ");
                System.out.println("Solution: " + x);
            } else {
                System.out.println("The quadratic equation has no solution.");
            }
        }
    }
}
