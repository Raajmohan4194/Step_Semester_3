import java.util.Scanner;
public class basiccal{
static void classifyNumber(int number){
if(number>0){
System.out.println("Positive");
}else if(number<0){
System.out.println("Negative");
}else{
System.out.println("Zero");
}
}
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
System.out.println("Enter any number:");
int number=sc.nextInt();
classifyNumber(number);
}
}