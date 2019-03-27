import java.util.*;
public class ccc13s5 {
	public static int getFactor(int n){
		int fac=0;
		for(int i=n-1;i>0;i--){
			if(n%i==0&&n-i>=1){
				fac=i;
				break;
			}
		}
		return fac;
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(), cnt=0;
		while(n!=1){
			int m=getFactor(n);
			n-=m;
			cnt+=n/m;
		}
		System.out.println(cnt);
		

	}

}
