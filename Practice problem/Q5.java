import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int num = sc.nextInt();
        int temp = num;
        int sum = 0;
        int reverse = 0;

        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            reverse = (reverse * 10) + digit;
            temp /= 10;
        }

        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reverse);
        sc.close();
    }
}