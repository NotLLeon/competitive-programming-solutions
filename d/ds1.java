import java.util.*;
import java.io.*;
public class ds1 {
	static long[] BIT;
	static long[] a;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()), m=Integer.parseInt(st.nextToken());
		BIT=new long[n];
		a=new long[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			int ad=Integer.parseInt(st.nextToken());
			update(i+1, ad);
			a[i]=ad;
		}
		for(int i=0;i<m;i++){
			st=new StringTokenizer(br.readLine());
			String s=st.nextToken();
			if(s.equals("C")){
				int ind=Integer.parseInt(st.nextToken()), val=Integer.parseInt(st.nextToken());
				update(ind, val);
				a[ind-1]=val;
			}else if(s.equals("S")){
				int n1=Integer.parseInt(st.nextToken()), n2=Integer.parseInt(st.nextToken());
				System.out.println(Query(n2)-Query(n1-1));
			}else if(s.equals("Q")){
				int k=Integer.parseInt(st.nextToken()), cnt=0;
				for(int j=0;j<n;j++){
					if(a[j]<=k){
						cnt++;
					}
				}
				System.out.println(cnt);
			}
		}
	}
	public static long Query(int x){
		long sum=0;
		while(x>0){
			sum+=BIT[x-1];
			x-=(x&-x);
		}
		return sum;
	}
	public static void update(int x, int y){
		long val=y-a[x-1];
		while(x<=BIT.length){
			BIT[x-1]+=val;
			x+=(x&-x);
		}
		
	}


}
