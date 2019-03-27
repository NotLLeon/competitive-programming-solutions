import java.util.*;
public class dmpg16s2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n=sc.nextLong(), k=sc.nextLong(), d=sc.nextLong(), ans=0;
		for(long i=Math.min((long)(Math.log(n)/Math.log(k)),d);i>=0;i--){
			long sm=pow(k, i);
			if(sm<=n){
				ans+=n/sm;
				n-=sm*(n/sm);
			}
		}
		System.out.println(ans);
	}
	static long pow(long a, long b){
		long n=1;
		for(long i=0;i<b;i++)n*=a;
		return n;
	}
}
