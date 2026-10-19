import java.util.Scanner;

abstract class Plot {
    String owner;
    Plot(String owner) {
        this.owner = owner;
    }
    abstract String getShape();
    abstract double getArea();
}

class CirclePlot extends Plot {
    double radius;
    CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }
    String getShape() {
        return "CIRCLE";
    }
    double getArea() {
        return Math.PI * radius * radius;
    }
}

class RectanglePlot extends Plot {
    double length;
    double width;
    RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }
    String getShape() {
        return "RECTANGLE";
    }
    double getArea() {
        return length * width;
    }
}

class TrianglePlot extends Plot {
    double base;
    double height;
    TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }
    String getShape() {
        return "TRIANGLE";
    }
    double getArea() {
        return 0.5 * base * height;
    }
}

 public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Plot[] plots = new Plot[n];
        double totalArea = 0.0;

        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();
            if (shape.equals("CIRCLE")) {
                double r = sc.nextDouble();
                plots[i] = new CirclePlot(owner, r);
            } else if (shape.equals("RECTANGLE")) {
                double l = sc.nextDouble();
                double w = sc.nextDouble();
                plots[i] = new RectanglePlot(owner, l, w);
            } else if (shape.equals("TRIANGLE")) {
                double b = sc.nextDouble();
                double h = sc.nextDouble();
                plots[i] = new TrianglePlot(owner, b, h);
            }
        }

        for (int i = 0; i < n; i++) {
            double area = plots[i].getArea();
            System.out.printf("%s (%s): %.2f\n", plots[i].owner, plots[i].getShape(), area);
            totalArea += area;
        }
        System.out.printf("Total Area: %.2f\n", totalArea);
        sc.close();
    }
}