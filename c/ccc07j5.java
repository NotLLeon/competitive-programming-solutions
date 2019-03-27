import java.util.*;
public class ccc07j5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt(), b=sc.nextInt(), n=sc.nextInt();
		long[]dp=new long[n+14], h=new long[n+14];
		h[0]=0;h[1]=990;h[2]=1010;h[3]=1970;h[4]=2030;h[5]=2940;h[6]=3060;h[7]=3930;h[8]=4060;h[9]=4970;h[10]=5030;h[11]=5990;h[12]=6010;h[13]=7000;
		for(int i=0;i<n;i++)h[14+i]=sc.nextInt();
		Arrays.sort(h);
		dp[0]=1;
		for(int j=0;j<n+13;j++){
			for(int i=j+1;i<n+14;i++){
				if(h[i]-h[j]<=b&&h[i]-h[j]>=a)dp[i]+=dp[j];
			}
		}
		System.out.println(dp[n+13]);

	}

}
