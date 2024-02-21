package lab2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество окружностей:");
        Circle[] circles = new Circle[scanner.nextInt()];
        for (int i = 0; i < circles.length; i++) {
            System.out.println("Введите координаты и радиус окружности " + (i + 1) + ":");
            circles[i] = new Circle();
            circles[i].setX();
            circles[i].setY();
            circles[i].setRadius();
            System.out.println("-----------------");
        }
        System.out.println("Окружности: ");
        for (Circle circle : circles) {
            System.out.println(circle);
        }
        System.out.println("-----------------");
        System.out.println("Окружности, центры которых лежат на одной прямой: ");
        for (int i = 0; i < circles.length - 2; i++) {
            for (int j = i + 1; j < circles.length - 1; j++) {
                for (int k = j + 1; k < circles.length; k++) {
                    if (isOnTheSameLine(circles[i], circles[j], circles[k])) {
                        System.out.println(circles[i]);
                        System.out.println(circles[j]);
                        System.out.println(circles[k]);
                        System.out.println("-----------------");
                    }
                }
            }
        }

        Circle maxAreaCircle = circles[0];
        Circle minAreaCircle = circles[0];
        Circle maxPerimeterCircle = circles[0];
        Circle minPerimeterCircle = circles[0];
        for (Circle circle : circles) {
            if (circle.getArea() > maxAreaCircle.getArea()) {
                maxAreaCircle = circle;
            }
            if (circle.getArea() < minAreaCircle.getArea()) {
                minAreaCircle = circle;
            }
            if (circle.getPerimeter() > maxPerimeterCircle.getPerimeter()) {
                maxPerimeterCircle = circle;
            }
            if (circle.getPerimeter() < minPerimeterCircle.getPerimeter()) {
                minPerimeterCircle = circle;
            }
        }
        System.out.println("\n-----------------");
        System.out.println("Окружность с наибольшей площадью: " + maxAreaCircle);
        System.out.println("Окружность с наименьшей площадью: " + minAreaCircle);
        System.out.println("Окружность с наибольшим периметром: " + maxPerimeterCircle);
        System.out.println("Окружность с наименьшим периметром: " + minPerimeterCircle);
    }

    public static boolean isOnTheSameLine(Circle c1, Circle c2, Circle c3) {
        return (c3.getX() - c1.getX()) / (c2.getX() - c1.getX()) == (c3.getY() - c1.getY()) / (c2.getY() - c1.getY());
    }
}
