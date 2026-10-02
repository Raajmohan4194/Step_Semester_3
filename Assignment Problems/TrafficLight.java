import java.util.Scanner;

public class TrafficLight {
    private final String id;
    private String color;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    public void next() {
        if (color.equals("RED")) {
            color = "GREEN";
        } else if (color.equals("GREEN")) {
            color = "YELLOW";
        } else if (color.equals("YELLOW")) {
            color = "RED";
        }
    }

    public String getColor() {
        return color;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        TrafficLight t = new TrafficLight(id);
        int cycles = sc.nextInt();
        System.out.println(t.getColor());
        for (int i = 0; i < cycles; i++) {
            t.next();
            System.out.println(t.getColor());
        }
        sc.close();
    }
}