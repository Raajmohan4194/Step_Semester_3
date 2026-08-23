import java.util.Scanner;
public class votecheck{
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
System.out.println("Enter the age of the candidate:");
int age=sc.nextInt();
if(age>=18){
System.out.println("Eligible to vote");
}else{
System.out.println("Not eligible to vote");
}
}
}