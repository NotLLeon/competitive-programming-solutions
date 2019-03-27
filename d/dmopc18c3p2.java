import java.util.*;
import java.io.*;
public class dmopc18c3p2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// pls help i dont know dp
		int n=Integer.parseInt(br.readLine());
		int[][]ab=new int[n][2];
		int[][]dp=new int[n][3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)ab[i][0]=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)ab[i][1]=Integer.parseInt(st.nextToken());
		for(int i=0;i<n;i++)for(int j=0;j<3;j++)dp[i][j]=Integer.MIN_VALUE;
		dp[0][0]=ab[0][1];
		dp[0][1]=ab[0][0];
		for(int i=1;i<n;i++){
			dp[i][0]=Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]))+ab[i][1];
			dp[i][1]=dp[i-1][0]+ab[i][0];
			dp[i][2]=dp[i-1][1]+ab[i][0];
		}
		System.out.println(Math.max(dp[n-1][0], Math.max(dp[n-1][1], dp[n-1][2])));
	}

}
