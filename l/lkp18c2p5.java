import java.util.*;
import java.io.*;
public class lkp18c2p5 {
	static long[]org;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()),d=Integer.parseInt(st.nextToken());
		org=new long[n];
		st=new StringTokenizer(br.readLine());
		long tot=0, cur=0;
		for(int i=0;i<n;i++){
			org[i]=Long.parseLong(st.nextToken());
			tot+=org[i];
		}
		long[]sort=new long[n];
		for(int i=0;i<n;i++)sort[i]=org[i];
		Arrays.sort(sort);
		int cnt=0, ind=n-1;
		while(cur*2<=tot){
			cnt++;
			cur+=sort[ind--];
		}
		System.out.println(cnt);
		for(int i=0;i<d;i++){
			st=new StringTokenizer(br.readLine());
			int p=Integer.parseInt(st.nextToken())-1;
			long v=Long.parseLong(st.nextToken());
			cur=0;
			tot+=v-org[p];
			org[p]=v;
			for(int j=0;j<n;j++)sort[j]=org[j];
			Arrays.sort(sort);
			cnt=0; ind=n-1;
			while(cur*2<=tot){
				cnt++;
				cur+=sort[ind--];
			}
			System.out.println(cnt);
		}
	}
}