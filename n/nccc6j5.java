import java.util.*; 
import java.io.*;
public class nccc6j5 { 
	static long mod=998244353;
	static long[][]dp;
	static int n, k;
	static int[]fs;
	public static void main(String[] args) throws IOException { 
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken()); k=Integer.parseInt(st.nextToken()); 
		fs=new int[n]; 
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)fs[Integer.parseInt(st.nextToken())-1]++;
		dp=new long[n][k];
		for(int i=0;i<n;i++)Arrays.fill(dp[i], -1);
		dp[0][0]=fs[0];
		for(int i=1;i<n;i++)dp[i][0]=fs[i]+dp[i-1][0];
		System.out.println(solve(n-1,k-1));
	} 
	static long solve(int ind, int rem){
		if(ind<0)return 0;
		if(dp[ind][rem]==-1){
			dp[ind][rem]=solve(ind-1,rem)+solve(ind-1,rem-1)*fs[ind];
			dp[ind][rem]%=mod;
		}
		return dp[ind][rem];
	}
}