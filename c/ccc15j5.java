import java.util.*;
public class ccc15j5 {
	static int[][]dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(), k=sc.nextInt();
		dp=new int[n+1][k+1];
		System.out.println(solve(n,k));
	}
	static int solve(int n, int k){
		System.out.println(n+" "+k);
		if(dp[n][k]!=0)return dp[n][k];
		else if(n==k||k==1)return 1;
		else if(n<k)return 0;
		return dp[n][k]=solve(n-1, k-1) + solve(n-k, k);
	}

}
