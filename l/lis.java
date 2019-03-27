import java.util.*;
import java.io.*;
public class lis {
	static int n;
	static int[] ar, dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		ar=new int[n]; dp=new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)ar[i]=Integer.parseInt(st.nextToken());
		dp[0]=1;
		for(int i=1;i<n;i++){
			for(int j=i-1;j>=0;j--){
				if(ar[j]<ar[i])dp[i]=Math.max(dp[i], dp[j]+1);
			}
		}
		System.out.println(dp[n-1]);

	}

}
