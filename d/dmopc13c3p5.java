import java.util.*;
import java.io.*;
public class dmopc13c3p5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m=Integer.parseInt(st.nextToken()), u=Integer.parseInt(st.nextToken()), r=Integer.parseInt(st.nextToken());
		int [][]arr=new int[r][3];
		int[][][]dp=new int[r][m+1][u+1];
		for(int i=0;i<r;i++){
			st= new StringTokenizer(br.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
			arr[i][2]=Integer.parseInt(st.nextToken());
		}
		dp[0][arr[0][1]][arr[0][2]]=arr[0][0];
		for(int i=1;i<r;i++){
			for(int j=0;j<=m;j++){
				for(int k=0;k<=u;k++){
					dp[i][j][k]=dp[i-1][j][k];
					if(j-arr[i][1]>=0&&k-arr[i][2]>=0){
						dp[i][j][k]=Math.max(dp[i][j][k], dp[i-1][j-arr[i][1]][k-arr[i][2]]+arr[i][0]);
					}
				}
			}
		}
		int max=0;
		for(int i=0;i<=m;i++){
			for(int j=0;j<=u;j++)max=Math.max(dp[r-1][i][j], max);
		}
		System.out.println(max);
	}

}
