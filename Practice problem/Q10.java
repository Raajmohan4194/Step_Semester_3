import java.util.Scanner;

class Student {
    String name;
    double[] marks;

    Student(String name, double[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double calculateAverage() {
        double sum = 0.0;
        for (int i = 0; i < marks.length; i++) {
            sum += marks[i];
        }
        return sum / marks.length;
    }

    char calculateGrade(double avg) {
        if (avg >= 75.0) {
            return 'B';
        } else if (avg >= 60.0) {
            return 'C';
        } else if (avg >= 40.0) {
            return 'D';
        } else {
            return 'F';
        }
    }

    void printResultCard() {
        double avg = calculateAverage();
        char grade = calculateGrade(avg);
        System.out.printf("%s: Average %.1f, Grade %c\n", name.toUpperCase(), avg, grade);
    }
}

public class Q10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = sc.next();
        double[] marks = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = sc.nextDouble();
        }

        Student student = new Student(name, marks);
        System.out.println("\n=== Result Card ===");
        student.printResultCard();
        sc.close();
    }
}