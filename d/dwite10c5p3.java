import java.util.*;
import java.io.*;
public class dwite10c5p3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=0;t<5;t++){
			int n=Integer.parseInt(br.readLine()), total=0;
			int[]ar=new int[n];
			boolean[]dp=new boolean[50000];
			for(int i=0;i<n;i++){
				ar[i]=Integer.parseInt(br.readLine());
				total+=ar[i];
				for(int j=dp.length-ar[i]-1;j>=0;j--){
					if(dp[j])dp[j+ar[i]]=true;
				}
				dp[ar[i]]=true;
			}
			boolean done=false;
			for(int i=total/2;i>=0;i--){
				if(dp[i]){
					System.out.println(total-2*i);
					done=true;
					break;
				}
			}
			if(!done)System.out.println(total);
		}
	}
}