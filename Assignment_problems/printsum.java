import java.util.Scanner;
public class printsum{
static void sumOfNaturalNumbers(int n){
int count=0;
int i=0;
while(i<n){
count+=i;
i++;
}
System.out.println("The sum is:"+count);
}
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
System.out.println("Enter any number:");
int n=sc.nextInt();
sumOfNaturalNumbers(n);
}
}