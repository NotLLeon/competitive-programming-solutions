
import java.util.*;
public class ccc12j1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b=sc.nextInt();
		
		if(b<=a){
			System.out.println("Congratulations, you are within the speed limit!");
		} else {
			int s =b-a;
			if(s>=1 && s<=20){
				System.out.println("You are speeding and your fine is $100.");
			} else if(s>=21 && s<=30){
				System.out.println("You are speeding and your fine is $270.");
			} else if(s>=31){
				System.out.println("You are speeding and your fine is $500.");
			}
		}
		
	}
}