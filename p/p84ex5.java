import java.util.*;
public class p84ex5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a=sc.nextDouble();
		double b=sc.nextDouble();
		if(a==0&&b==0){
			System.out.println("indeterminate");
		} else if(a==0){
			System.out.println("undefined");
		} else {
			double x=-b/a;
			System.out.printf("%.2f", x);
		}
	}

}
