import java.util.*;
public class year2018p1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long h=sc.nextLong(), m=sc.nextLong(), s=sc.nextLong();
		m+=s/60;
		s%=60;
		h+=m/60;
		m%=60;
		if(s!=0)m++;
		if(m!=0)h++;
		System.out.printf("%02d", check1(12-h,12));
		System.out.print(":");
		System.out.printf("%02d", check(0-m,60));
		System.out.print(":");
		System.out.printf("%02d", check(0-s,60));
	}
	static long check(long n,long x){
		if(n>=0)return n;
		else return x+n;
	}
	static long check1(long n,long x){
		if(n>0)return n;
		while(n<0)n+=x;
		return n;
	}
}
