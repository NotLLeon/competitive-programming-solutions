import java.util.*;
public class dmopc17c3p1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n=sc.nextLong();
		int []m=new int[(int) n];
		long min=Long.MAX_VALUE;
		for(int i=0;i<n;i++){
			min=Math.min(min,sc.nextInt());
		}
		System.out.println(min);

	}

}
