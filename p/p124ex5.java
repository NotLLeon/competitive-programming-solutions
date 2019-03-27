import java.util.*;
public class p124ex5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=0;i<N;i++){
			double a = sc.nextDouble();
			double b = sc.nextDouble();
			double pow=Math.pow(a, b);
			System.out.printf("%.2f%n", pow);
		}

	}

}
