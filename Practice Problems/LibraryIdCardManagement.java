import java.util.Scanner;

class IdCard {
    String name;
    int booksIssued;

    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }
}

public class LibraryIdCardManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.next();

        System.out.print("Enter initial books issued: ");
        int booksIssued = sc.nextInt();

        IdCard ravi = new IdCard(name, booksIssued);
        IdCard duplicate = ravi;

        System.out.print("Enter new books issued (via duplicate): ");
        int newBooksIssued = sc.nextInt();
        duplicate.booksIssued = newBooksIssued;

        IdCard separate = new IdCard(name, newBooksIssued);

        System.out.println(name + "'s booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));
        System.out.println("separate == ravi: " + (separate == ravi));

        sc.close();
    }
}
