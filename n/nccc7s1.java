import java.util.*;
public class nccc7s1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n=sc.nextLong(), m=sc.nextLong(), p=n*m;
		System.out.print((p)/2);
		if(p%2!=0)System.out.println(".5");
		else System.out.println(".0");
	}
}
