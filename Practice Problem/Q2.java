import java.util.Scanner;

class Student {
    private String name;
    private int m1, m2, m3;

    Student(String name) {
        this.name = name;
    }

    public boolean setMarks(int a, int b, int c) {
        if (a < 0 || a > 100 || b < 0 || b > 100 || c < 0 || c > 100) {
            return false;
        }
        this.m1 = a;
        this.m2 = b;
        this.m3 = c;
        return true;
    }

    public int getTotal() {
        return m1 + m2 + m3;
    }

    public double getAverage() {
        return getTotal() / 3.0;
    }

    public char getGrade() {
        double avg = getAverage();
        if (avg >= 80) return 'A';
        if (avg >= 70) return 'B';
        if (avg >= 60) return 'C';
        if (avg >= 40) return 'D';
        return 'F';
    }

    @Override
    public String toString() {
        return String.format("%s total=%d avg=%.2f grade=%c", name, getTotal(), getAverage(), getGrade());
    }
}

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        Student[] validStudents = new Student[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name and three marks: ");
            String name = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            Student s = new Student(name);
            if (s.setMarks(a, b, c)) {
                validStudents[count++] = s;
            } else {
                System.out.println(name + " skipped: marks must be 0 to 100");
            }
        }

        int passes = 0;
        for (int i = 0; i < count - 1; i++) {
            boolean swapped = false;
            passes++;
            for (int j = 0; j < count - 1 - i; j++) {
                if (validStudents[j].getTotal() < validStudents[j + 1].getTotal()) {
                    Student temp = validStudents[j];
                    validStudents[j] = validStudents[j + 1];
                    validStudents[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + validStudents[i]);
        }
        System.out.println("Sorted in " + passes + " passes");
        sc.close();
    }
}