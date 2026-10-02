import java.util.Scanner;

class HallTicket {
    String studentName;
    int seatNumber;

    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        int initialSeat = sc.nextInt();
        int updatedSeat = sc.nextInt();

        HallTicket priya = new HallTicket(name, initialSeat);
        HallTicket copy = priya;
        copy.seatNumber = updatedSeat;

        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));

        HallTicket separate = new HallTicket(name, updatedSeat);
        System.out.println("separate == priya: " + (separate == priya));
        sc.close();
    }
}