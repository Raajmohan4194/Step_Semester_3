import java.util.Scanner;

class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
    }
}

public class Q1 {
    public static Node build(String[] stops) {
        if (stops.length == 0) return null;
        Node head = new Node(stops[0]);
        Node current = head;
        for (int i = 1; i < stops.length; i++) {
            current.next = new Node(stops[i]);
            current = current.next;
        }
        return head;
    }

    public static void printRoute(Node head) {
        if (head == null) {
            System.out.println("null");
            System.out.println("Stops: 0, First: None, Last: None");
            return;
        }
        Node current = head;
        int count = 0;
        String first = head.data;
        String last = head.data;

        while (current != null) {
            System.out.print(current.data + " -> ");
            count++;
            last = current.data;
            current = current.next;
        }
        System.out.println("null");
        System.out.println("Stops: " + count + ", First: " + first + ", Last: " + last);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of stops: ");
        int n = sc.nextInt();
        String[] stops = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter stop " + (i + 1) + ": ");
            stops[i] = sc.next();
        }
        Node head = build(stops);
        printRoute(head);
        sc.close();
    }
}