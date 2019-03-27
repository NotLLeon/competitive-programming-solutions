import java.util.*;
import java.io.*;
public class dpa {
 
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()), w=Integer.parseInt(st.nextToken());
		long[]dp=new long[w+1],p=new long[w+1];
		int[]ws=new int[n];
		long[]vs=new long[n];
		for(int i=0;i<n;i++){
			st=new StringTokenizer(br.readLine());
			ws[i]=Integer.parseInt(st.nextToken());
			vs[i]=Long.parseLong(st.nextToken());
		}
		p[ws[0]]=vs[0];
		for(int i=1;i<n;i++){
			for(int j=0;j<=w;j++){
				dp[j]=p[j];
				if(j-ws[i]>-1)dp[j]=Math.max(dp[j], vs[i]+p[j-ws[i]]);
			}
			for(int j=0;j<=w;j++){
				p[j]=dp[j];
				dp[j]=0;
			}
		}
		long max=0;
		for(int i=0;i<=w;i++)max=Math.max(max,p[i]);
		System.out.println(max);
	}
}