import java.util.*;
import java.io.*;
public class dpq {
	static int n;
	static flower[]fs;
	static long[]bit;
	static class flower implements Comparable<flower>{
		int h,ind;
		long a;
		flower(int b, long c, int d){
			h=b;
			a=c;
			ind=d;
		}
		public int compareTo(flower e){
			return this.h-e.h;
		}
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		fs=new flower[n];
		bit=new long[n+1];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)fs[i]=new flower(Integer.parseInt(st.nextToken()),-1,i);
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)fs[i].a=Long.parseLong(st.nextToken());
		Arrays.sort(fs);
		long[]dp=new long[n];
		for(int i=0;i<n;i++){
			dp[fs[i].ind]=query(fs[i].ind)+fs[i].a;
			update(fs[i].ind,dp[fs[i].ind]);
		}
		long ans=0;
		for(int i=0;i<n;i++)ans=Math.max(ans, dp[i]);
		System.out.println(ans);
	}
	static void update(int i, long val){
		i++;
		for(;i<bit.length;i+=(i&-i))bit[i]=Math.max(bit[i], val);
	}
	static long query(int i){
		long max=0;
		for(;i>0;i-=(i&-i))max=Math.max(max, bit[i]);
		return max;
	}
}
