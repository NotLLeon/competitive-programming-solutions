import java.util.*;
import java.io.*;
public class olyq2p1 {
	static int n,m;
	static long[]pos;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken()); m=Integer.parseInt(st.nextToken());
		pos=new long[n];
		for(int i=0;i<n;i++)pos[i]=Long.parseLong(br.readLine());
		Arrays.sort(pos);
		int l=0,r=1000000000, mid=0;
		while(true){
			 mid=(l+r)/2;
			 if(check(mid)&&!check(mid+1))break;
			 else if(!check(mid))r=mid-1;
			 else l=mid+1;
		}
		System.out.println(mid);
	}
	static boolean check(int min){
		int cnt=1;
		long last=pos[0];
		for(int i=1;i<n;i++){
			if(pos[i]-last>=min){
				cnt++;
				last=pos[i];
			}
		}
		return cnt>=m;
	}

}
