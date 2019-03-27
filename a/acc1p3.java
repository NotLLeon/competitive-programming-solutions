import java.util.*;
import java.io.*;
public class acc1p3 {
	static int n;
	static long t,m;
	static PriorityQueue<p>pq;
	static class p implements Comparable<p>{
		long a,b,k;
		p(long a1,long a2, long a3){
			a=a1;b=a2;k=a3;
		}
		public int compareTo(p e){
			if(this.a-(this.k-1)*this.b<e.a-(e.k-1)*e.b)return -1;
			else return 1;
		}
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		t=Long.parseLong(st.nextToken());
		pq=new PriorityQueue<p>();
		m=998244353;
		for(int i=0;i<n;i++){
			st=new StringTokenizer(br.readLine());
			pq.add(new p(Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()),1));
		}
		p hi=pq.poll(), se=pq.peek();
		long cur=0, in=0, ans=0;
		while(cur<t){
			
			in=Math.max(cur+1, Math.min(t, (hi.a-hi.b-se.a)/hi.k));
			if(cur==in)in++;
			System.out.println(cur+" "+in);
			ans+=(in-cur)*hi.a-hi.b*sum(in,cur);
			pq.add(new p(hi.a, hi.b, hi.k+in-cur));
			hi=pq.poll();
			se=pq.peek();
			cur=in;
		}
		System.out.println(ans);

	}
	static long sum(long a, long b){
		return b*(b+1)/2-a*(a+1)/2;
	}

}
