import java.util.*;
import java.io.*;
public class tsoc15c2p6 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stt;
	static long[]seg; static long[]lazy;static long min;
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()), q=Integer.parseInt(st.nextToken());
		seg=new long[90000];lazy=new long[90000];
		stt=new StringTokenizer(br.readLine());
		build(1,n,1);
		for(int l=0;l<q;l++){
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken()), b=Integer.parseInt(st.nextToken()), c=Integer.parseInt(st.nextToken());
			min=2000000000;
			update(1,n,a,b,c,1);
			System.out.println(min+" "+seg[1]);
		}

	}
	static void build(int l, int r,int cur){
		if(l==r){
			seg[cur]=Integer.parseInt(stt.nextToken());
			return;
		}
		int mid=(l+r)/2;
		build(l, mid, cur*2);build(mid+1,r,cur*2+1);
		seg[cur]=Math.min(seg[cur*2], seg[cur*2+1]);
	}
	static void update(int cl, int cr,int l, int r ,int v,int cur){
		if(lazy[cur]!=0){
			seg[cur]-=lazy[cur];
			check(cur);
			if(cl!=cr){
				lazy[cur*2]+=lazy[cur];
				lazy[cur*2+1]+=lazy[cur];
			}
			lazy[cur]=0;
		}
		if(cr<l||cl>r){
			return;
		}
		if(cr<=r&&cl>=l){
			seg[cur]-=v;
			check(cur);
			if(cl!=cr){
				lazy[cur*2]+=v;
				lazy[cur*2+1]+=v;
			}
			min=Math.min(min, seg[cur]+lazy[cur]);
			return;
		}
		int mid=(cl+cr)/2;
		update(cl,mid,l,r,v,cur*2);update(mid+1,cr,l,r,v,cur*2+1);
		seg[cur]=Math.min(seg[cur*2], seg[cur*2+1]);
		check(cur);
	}
	static void check(int cur){
		if(seg[cur]<0)seg[cur]=0;
	}
}