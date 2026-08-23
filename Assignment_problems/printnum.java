import java.util.Scanner;
public class printnum{
	static void printNumbersUpToN(int n){
	for(int i=1; i<n; i++){
	System.out.println(n);
	}
	}
	public static void main(String[] args){
	Scanner sc= new Scanner(System.in);
	System.out.println("Enter any number:");
	int n=sc.nextInt();
	printNumbersUpToN(n);
	} 

}