import java.util.Scanner;
import java.time.LocalDate;

abstract class LibraryItem {
    String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract LocalDate calculateDueDate(LocalDate currentDate);
}

class BookItem extends LibraryItem {
    public BookItem(String title) {
        super(title);
    }

    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(14);
    }
}

class DVDItem extends LibraryItem {
    public DVDItem(String title) {
        super(title);
    }

    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(7);
    }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title) {
        super(title);
    }

    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(3);
    }
}

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        LibraryItem[] items = new LibraryItem[n];
        LocalDate currentDate = LocalDate.parse("2023-10-26");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            int firstSpace = line.indexOf(' ');
            String type = line.substring(0, firstSpace);
            String title = line.substring(firstSpace + 1).replace("\"", "");

            if (type.equalsIgnoreCase("BOOK")) {
                items[i] = new BookItem(title);
            } else if (type.equalsIgnoreCase("DVD")) {
                items[i] = new DVDItem(title);
            } else {
                items[i] = new MagazineItem(title);
            }
        }

        for (int i = 0; i < items.length; i++) {
            LocalDate dueDate = items[i].calculateDueDate(currentDate);
            System.out.println(items[i].getTitle() + ": " + dueDate);
        }
        sc.close();
    }
}