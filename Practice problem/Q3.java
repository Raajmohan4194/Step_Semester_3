import java.util.Scanner;

abstract class LibraryItem {
    String title;
    int daysLate;
    LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }
    abstract double calculateFine();
}

class Book extends LibraryItem {
    Book(String title, int daysLate) {
        super(title, daysLate);
    }
    double calculateFine() {
        return daysLate * 2.0;
    }
}

class DVD extends LibraryItem {
    DVD(String title, int daysLate) {
        super(title, daysLate);
    }
    double calculateFine() {
        double fine = daysLate * 5.0;
        return fine > 50.0 ? 50.0 : fine;
    }
}

class Magazine extends LibraryItem {
    Magazine(String title, int daysLate) {
        super(title, daysLate);
    }
    double calculateFine() {
        return daysLate * 1.0;
    }
}

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of returned items: ");
        int n = sc.nextInt();
        LibraryItem[] items = new LibraryItem[n];
        double totalFines = 0.0;

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Item " + (i + 1) + " ---");
            System.out.print("Enter item type (BOOK / DVD / MAGAZINE): ");
            String type = sc.next().toUpperCase();
            System.out.print("Enter item title: ");
            String title = sc.next();
            System.out.print("Enter days late: ");
            int days = sc.nextInt();

            if (type.equals("BOOK")) {
                items[i] = new Book(title, days);
            } else if (type.equals("DVD")) {
                items[i] = new DVD(title, days);
            } else if (type.equals("MAGAZINE")) {
                items[i] = new Magazine(title, days);
            } else {
                System.out.println("Invalid item type!");
                i--;
            }
        }

        System.out.println("\n=== Library Fine Report ===");
        for (int i = 0; i < n; i++) {
            double fine = items[i].calculateFine();
            System.out.printf("%s: %.2f\n", items[i].title, fine);
            totalFines += fine;
        }
        System.out.printf("Total Fines: %.2f\n", totalFines);
        sc.close();
    }
}