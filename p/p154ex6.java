import java.util.*;
public class p154ex6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double P = sc.nextDouble();
		double A = sc.nextDouble();
		int Y = sc.nextInt();
		double B = sc.nextDouble();
		
		while(A<=B){
			A=A+(A*(P/100));
			Y++;
			
		}
		System.out.println(Y);
	}

}
