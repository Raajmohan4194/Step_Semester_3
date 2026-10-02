import java.util.Scanner;

public class AttendanceSheet {
    private String[] presentStudents;
    private int count;

    public AttendanceSheet(int maxCapacity) {
        this.presentStudents = new String[maxCapacity];
        this.count = 0;
    }

    public void markPresent(String name) {
        if (count < presentStudents.length && !isPresent(name)) {
            presentStudents[count] = name;
            count++;
        }
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public int getPresentCount() {
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int capacity = sc.nextInt();
        AttendanceSheet sheet = new AttendanceSheet(capacity);
        int marksCount = sc.nextInt();
        for (int i = 0; i < marksCount; i++) {
            String name = sc.next();
            sheet.markPresent(name);
        }
        System.out.println(sheet.getPresentCount());
        String checkName = sc.next();
        System.out.println(sheet.isPresent(checkName));
        sc.close();
    }
}