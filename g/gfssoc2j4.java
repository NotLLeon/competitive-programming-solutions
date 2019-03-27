import java.util.*;
import java.io.*;
public class gfssoc2j4 {
	static int[] bit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()), q=Integer.parseInt(st.nextToken());
		bit=new int[n+1];
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<n+1;i++){
			update(i,Integer.parseInt(st.nextToken()));
		}
		int total=query(n);
		for(int i=0;i<q;i++){
			st=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken()), to=Integer.parseInt(st.nextToken());
			System.out.println(total-query(to)+query(from-1));
		}
	}
	public static void update(int ind, int val){
		for(;ind<bit.length;ind+=(ind&-ind)){
			bit[ind]+=val;
		}
	}
	public static int query(int ind){
		int sum=0;
		for(;ind>0;ind-=(ind&-ind)){
			sum+=bit[ind];
		}
		return sum;
	}

}
