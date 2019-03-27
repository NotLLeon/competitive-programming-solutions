import java.util.*;
import java.io.*;
public class ccoprep16c2q2 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[]ar=new int[n], dp=new int[n];
		for(int i=0;i<n;i++)ar[i]=Integer.parseInt(st.nextToken());
		int[]last=new int[32];
		Arrays.fill(last, 0);
		for(int i=0;i<32;i++)if((ar[0]&(1<<i))!=0)last[i]=1;
		dp[0]=1;
		for(int i=1;i<n;i++){
			int mi=-1;
			dp[i]=dp[i-1];
			for(int j=0;j<32;j++){
				if(((ar[i]&(1<<j))!=0)&&(mi==-1||last[j]>last[mi]))mi=j;
			}
			if(mi!=-1){
				int t=last[mi]+1;
				dp[i]=Math.max(dp[i], t);
				for(int j=0;j<32;j++)if(((ar[i]&(1<<j))!=0)){
					last[j]=Math.max(last[j],t);
				}
			}else{
				for(int j=0;j<32;j++)if(((ar[i]&(1<<j))!=0))last[j]=Math.max(last[j], 1);
			}
		}
		System.out.println(dp[n-1]);
	}

}
