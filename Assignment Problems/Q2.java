import java.util.Scanner;

class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
    }
}

public class Q2 {
    public static Node addFirst(Node head, String name) {
        Node newNode = new Node(name);
        newNode.next = head;
        return newNode;
    }

    public static Node addLast(Node head, String name) {
        Node newNode = new Node(name);
        if (head == null) return newNode;
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    public static void printLine(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;

        System.out.print("Enter starting line length: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter student " + (i + 1) + ": ");
            head = addLast(head, sc.next());
        }

        System.out.print("Enter number of operations: ");
        int ops = sc.nextInt();
        for (int i = 0; i < ops; i++) {
            System.out.print("Enter operation (addFirst/addLast) and student name: ");
            String op = sc.next();
            String name = sc.next();
            if (op.equalsIgnoreCase("addFirst")) {
                head = addFirst(head, name);
            } else if (op.equalsIgnoreCase("addLast")) {
                head = addLast(head, name);
            }
        }
        printLine(head);
        sc.close();
    }
}