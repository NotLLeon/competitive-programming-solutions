import java.util.*;
public class utso15p3 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(), m=sc.nextInt();
		long MOD=1000000007;
		if(m==1)System.out.println(1);
		else if(m==2){
			long[]dp=new long[n+2];
			dp[2]=1;
			for(int i=3;i<n+2;i++)dp[i]=(dp[i-1]+dp[i-3])%MOD;
			System.out.println(dp[n+1]);
		}else{
			long[][]dp=new long[n+3][5];
			dp[3][0]=1;
			for(int i=3;i<n+3;i++){
				dp[i][1]=(dp[i-2][0]+dp[i-3][3]+dp[i-1][4]+dp[i-3][4])%MOD;
				dp[i][3]=(dp[i-1][0]+dp[i-2][0]+dp[i-3][3]+dp[i-1][4]+dp[i-3][4])%MOD;
				dp[i][2]=(dp[i-2][0]+dp[i][3])%MOD;
				if(i!=3)dp[i][0]=(dp[i-1][0]+dp[i-2][1]+dp[i-3][2])%MOD;
				dp[i][4]=(dp[i][0]+dp[i-1][1])%MOD;
			}
			System.out.println(dp[n+2][0]);
		}

	}

}
