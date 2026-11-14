import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] stack = new String[3];
        int top = -1;

        String[] queue = new String[3];
        int front = 0, rear = -1, qSize = 0;

        System.out.print("Enter number of commands: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter command: ");
            String cmd = sc.next().toUpperCase();

            if (cmd.equals("RETURN")) {
                String book = sc.next();
                if (top == 2) {
                    System.out.println(book + " rejected: pile is full");
                } else {
                    stack[++top] = book;
                    System.out.println(book + " placed on pile");
                }
            } else if (cmd.equals("SHELVE")) {
                if (top == -1) {
                    System.out.println("pile is empty");
                } else {
                    System.out.println("shelved " + stack[top--]);
                }
            } else if (cmd.equals("WAIT")) {
                String student = sc.next();
                if (qSize == 3) {
                    System.out.println(student + " rejected: line is full");
                } else {
                    rear = (rear + 1) % 3;
                    queue[rear] = student;
                    qSize++;
                    System.out.println(student + " joined the line");
                }
            } else if (cmd.equals("SERVE")) {
                if (qSize == 0) {
                    System.out.println("no one waiting");
                } else {
                    System.out.println("served " + queue[front]);
                    front = (front + 1) % 3;
                    qSize--;
                }
            }
        }
        sc.close();
    }
}