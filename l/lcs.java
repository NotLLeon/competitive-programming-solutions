import java.util.*;
public class lcs {
	static int [][]dp;
	static int []s1, s2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(), m=sc.nextInt();
		s1=new int[n]; s2=new int[m];
		for(int i=0;i<n;i++)s1[i]=sc.nextInt();
		for(int i=0;i<m;i++)s2[i]=sc.nextInt();
		dp=new int[n+1][m+1];
		for(int i=0;i<=n;i++){
			for(int j=0;j<=m;j++){
				if(i==0||j==0)dp[i][j]=0;
				else if(s1[i-1]==s2[j-1])dp[i][j]=dp[i-1][j-1]+1;
				else dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}
		System.out.println(dp[n][m]);
	}
}
