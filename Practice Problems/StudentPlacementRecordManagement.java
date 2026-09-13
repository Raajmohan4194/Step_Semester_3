import java.util.Scanner;

class PlacementRecord {
    String studentName;
    String company;
    double packageLpa;

    public PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    void printRecord() {
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }
}

public class StudentPlacementRecordManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        PlacementRecord[] records = new PlacementRecord[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = sc.next();

            System.out.print("Enter company: ");
            String company = sc.next();

            System.out.print("Enter package (LPA): ");
            double packageLpa = sc.nextDouble();

            records[i] = new PlacementRecord(name, company, packageLpa);
        }

        for (int i = 0; i < n; i++) {
            records[i].printRecord();
        }

        sc.close();
    }
}
