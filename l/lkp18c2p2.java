import java.util.*;
import java.io.*;
public class lkp18c2p2 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()), k=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int[]ar=new int[n], m=new int[k];
		long sum=0;
		for(int i=0;i<n;i++){
			ar[i]=Integer.parseInt(st.nextToken());
			sum+=ar[i];
			m[(int) (sum%k)]++;
		}
		long ans=m[0];
		for(int i=0;i<k;i++){
			if(m[i]>1)ans+=(m[i]*(m[i]-1))/2;
		}
		System.out.println(ans);
	}

}
