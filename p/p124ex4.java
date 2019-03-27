import java.util.*;
public class p124ex4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double p = sc.nextDouble();
		int y = sc.nextInt();
		double n = sc.nextDouble();
		int y2=sc.nextInt();
		double t=n;
		p=(p/100)+1;
		
		int d = y2-y;
		for(int i=0;i<d;i++){
			t=t*p;
		}
		System.out.printf("%.0f\n", t);
	}

}
