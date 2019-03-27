/*
ID: NotLeon
LANG: JAVA
TASK: teamwork
 */
import java.util.*;
import java.io.*;
public class teamwork {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("teamwork.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("teamwork.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()), k=Integer.parseInt(st.nextToken());
		int[][]dp=new int[n][k],max=new int[n][k];
		int[]best=new int[n];
		dp[0][0]=Integer.parseInt(br.readLine());
		max[0][0]=dp[0][0];
		best[0]=1;
		for(int i=1;i<n;i++){
			int cur=Integer.parseInt(br.readLine());
			for(int j=0;j<k;j++){
				dp[i][0]=Math.max(dp[i][0], dp[i-1][j]);
			}
			max[i][0]=cur;
			dp[i][0]+=cur;
			for(int j=1;j<Math.min(i+1,k);j++){
				max[i][j]=Math.max(max[i-1][j-1], cur);
				dp[i][j]=(j+1)*max[i][j]+(i-j-1>-1?best[i-j-1]:0);
			}
			for(int j=0;j<k;j++)best[i]=Math.max(best[i], dp[i][j]);
		}
		int ans=0;
		for(int i=0;i<k;i++)ans=Math.max(ans, dp[n-1][i]);
		out.println(ans);
		out.close();
	}
}