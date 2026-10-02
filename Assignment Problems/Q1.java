import java.util.Scanner;

class BookInventory {
    String title;
    String author;
    int copiesAvailable;

    public BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    public void printEntry() {
        System.out.println(title + " by " + author + " " + copiesAvailable + " copies available");
    }
}

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookInventory[] books = new BookInventory[4];
        for (int i = 0; i < 4; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(",\\s*");
            String title = parts[0];
            String author = parts[1];
            int copies = Integer.parseInt(parts[2]);
            books[i] = new BookInventory(title, author, copies);
        }
        for (int i = 0; i < books.length; i++) {
            books[i].printEntry();
        }
        sc.close();
    }
}