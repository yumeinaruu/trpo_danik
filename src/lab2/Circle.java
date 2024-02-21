package lab2;

import java.util.Scanner;

public class Circle {
    Scanner scanner = new Scanner(System.in);
    private double x;
    private double y;
    private double radius;

    public Circle() {
    }

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void setX() {
        System.out.println("Введите x:");
        this.x = scanner.nextDouble();
    }

    public void setY() {
        System.out.println("Введите y:");
        this.y = scanner.nextDouble();
    }

    public void setRadius() {
        System.out.println("Введите радиус:");
        this.radius = scanner.nextDouble();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public String toString() {
        return "Окружность {" +
                "x=" + x +
                ", y=" + y +
                ", радиус=" + radius +
                '}';
    }
}
