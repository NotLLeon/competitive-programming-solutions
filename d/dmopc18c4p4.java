import java.util.*;
import java.io.*;
public class dmopc18c4p4 {
	static class query implements Comparable<query>{
		int l,r,k, ind;
		query(int a, int b, int c, int d){
			l=a;
			r=b;
			k=c;
			ind=d;
		}
		public int compareTo(query e){
			return this.k-e.k;
		}
	}
	static class num implements Comparable<num>{
		int ind, val;
		num(int a, int b){
			ind=a;
			val=b;
		}
		public int compareTo(num e){
			return this.val-e.val;
		}
	}
	static long bit[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()), q=Integer.parseInt(st.nextToken());
		int[]ar=new int[n];
		num[]us=new num[n];
		long[]psa=new long[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			ar[i]=Integer.parseInt(st.nextToken());
			psa[i+1]=psa[i]+ar[i];
			us[i]=new num(i+1,ar[i]);
		}
		query[]qs=new query[q];
		for(int i=0;i<q;i++){
			st = new StringTokenizer(br.readLine());
			int l=Integer.parseInt(st.nextToken()), r=Integer.parseInt(st.nextToken()), k=Integer.parseInt(st.nextToken());
			qs[i]=new query(l,r,k,i);
		}
		bit=new long[500000];
		Arrays.sort(qs);
		Arrays.sort(us);
		long[]ans=new long[q];
		int i1=0, i2=0;
		while(i1<q){
			if(i2==n||qs[i1].k<=us[i2].val){
				long tot=psa[qs[i1].r]-psa[qs[i1].l-1], nq=sum(qs[i1].r+1)-sum(qs[i1].l);
				ans[qs[i1].ind]=tot-2*nq;
				i1++;
			}else{
				update(us[i2].ind+1, us[i2].val);
				i2++;
			}
		}
		for(int i=0;i<q;i++)System.out.println(ans[i]);
	}
	static void update(int x,long val){
		for(;x<bit.length;x+=(x&-x))bit[x]+=val;
	}
	static long sum(int x){
		long sum=0;
		for(;x>0;x-=(x&-x))sum+=bit[x];
		return sum;
	}

}
