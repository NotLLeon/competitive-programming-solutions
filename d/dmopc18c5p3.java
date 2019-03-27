import java.util.*;
import java.io.*;
public class dmopc18c5p3 {

	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		long m=Long.parseLong(st.nextToken());
		long[]ar=new long[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			ar[i]=Long.parseLong(st.nextToken());
		}
		int l=0, r=0, cs=0, max=0;
		long cur=0;
		while(r<n){
			if(ar[r]+cur<m){
				cur+=ar[r];
				r++;
				cs++;
				max=Math.max(max, cs);
			}else{
				cur-=ar[l];
				l++;
				cs--;
			}
		}
		System.out.println(max);
		
	}

}
