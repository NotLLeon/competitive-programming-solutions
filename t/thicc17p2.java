import java.util.*;
public class thicc17p2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(), a=sc.nextInt(), b=sc.nextInt(), m=sc.nextInt();
		long []ans=new long[n];
		ans[0]=a;
		for(int i=1;i<n;i++){
			ans[i]=(ans[i-1]*b)%m;
		}
		long total=0;
		for(int i=0;i<n-1;i++){
			for(int j=i+1;j<n;j++){
				total+=((ans[i]*ans[j])*2)%1000000007;
			}
		}
		System.out.println(total%1000000007);

	}

}
