import java.util.Scanner;

public class AttendanceTracker {
    static void attendanceSummary(int[] days) {
        int presentCount = 0;
        int currentStreak = 0;
        int longestStreak = 0;

        for (int i = 0; i < days.length; i++) {
            if (days[i] == 1) {
                presentCount++;
                currentStreak++;
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }

        System.out.println("Present: " + presentCount + ", Longest streak: " + longestStreak);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total number of days: ");
        int n = sc.nextInt();
        int[] days = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter attendance for day " + (i + 1) + " (1 for Present, 0 for Absent): ");
            int status = sc.nextInt();
            if (status == 0 || status == 1) {
                days[i] = status;
            } else {
                System.out.println("Invalid input! Please enter only 0 or 1.");
                i--;
            }
        }

        System.out.println("\n=== Attendance Summary ===");
        attendanceSummary(days);
        sc.close();
    }
}