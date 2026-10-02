import java.util.Scanner;

public class NameTag {
    private final String firstName;
    private final String lastName;

    public NameTag(String fullName) {
        String[] parts = fullName.split(" ");
        this.firstName = parts[0];
        this.lastName = parts[1];
    }

    public String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fullName = sc.nextLine();
        NameTag tag = new NameTag(fullName);
        System.out.println(tag.getNickname());
        sc.close();
    }
}