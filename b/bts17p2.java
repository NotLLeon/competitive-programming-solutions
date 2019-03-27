import java.util.*;
public class bts17p2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		double ans=1.0;
		for(int i=0;i<n;i++){
			double e=sc.nextDouble(), p=sc.nextDouble();
			ans*=((p-e)/p);
		}
		System.out.println(ans);

	}

}
