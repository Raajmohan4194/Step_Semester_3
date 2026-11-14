import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rooms: ");
        int n = sc.nextInt();

        String[] rooms = new String[n];
        int[] readings = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter room number and reading: ");
            rooms[i] = sc.next();
            readings[i] = sc.nextInt();
        }

        int roomsBilled = 0;
        int totalAmount = 0;

        for (int i = 0; i < n; i++) {
            int units = readings[i];
            if (units < 0) {
                System.out.println(rooms[i] + ": invalid reading");
            } else {
                int bill = 50;
                if (units <= 100) {
                    bill += units * 3;
                } else if (units <= 200) {
                    bill += (100 * 3) + ((units - 100) * 5);
                } else {
                    bill += (100 * 3) + (100 * 5) + ((units - 200) * 8);
                }
                roomsBilled++;
                totalAmount += bill;
                System.out.println(rooms[i] + ": " + units + " units, bill " + bill);
            }
        }
        System.out.println("Rooms billed " + roomsBilled + ", total " + totalAmount);
        sc.close();
    }
}