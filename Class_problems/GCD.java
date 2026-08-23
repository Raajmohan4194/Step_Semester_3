import java.util.*;
class GCD{
public static void main(String[]args){
Scanner sc=new Scanner(System.in);
int number1=sc.nextInt();
int number2=sc.nextInt();
int original1=number1;
int original2=number2;
while(number2!=0){
int remainder=number1%number2;
number1=number2;
number2=remainder;
}
System.out.println("The GCD of "+original1+" and "+original2+" is "+number1);
}
}