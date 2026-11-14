import java.util.Scanner;

class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
    }
}

public class Q3 {
    public static String find(Node head, String id) {
        Node current = head;
        int pos = 1;
        int firstPos = -1;
        int copies = 0;

        while (current != null) {
            if (current.data.equals(id)) {
                if (firstPos == -1) {
                    firstPos = pos;
                }
                copies++;
            }
            pos++;
            current = current.next;
        }

        if (copies == 0) {
            return id + " not found";
        }
        return id + " first at position " + firstPos + ", copies: " + copies;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of books on trolley: ");
        int n = sc.nextInt();
        Node head = null, tail = null;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter book ID " + (i + 1) + ": ");
            Node newNode = new Node(sc.next());
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        System.out.print("Enter book ID to search: ");
        String id = sc.next();
        System.out.println(find(head, id));
        sc.close();
    }
}