import java.util.*;
import java.io.*;
public class dmopc18c4p2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine()), total=0;
		int[]ar=new int[n];
		boolean[]dp=new boolean[500000];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			ar[i]=Integer.parseInt(st.nextToken());
			total+=ar[i];
			for(int j=0;j<dp.length-ar[i];j++){
				if(dp[j])dp[j+ar[i]]=true;
			}
			dp[ar[i]]=true;
		}
		for(int i=total/2;i>=0;i--){
			if(dp[i]){
				System.out.println(total-2*i);
				return;
			}
		}
		System.out.println(total);
	}

}
