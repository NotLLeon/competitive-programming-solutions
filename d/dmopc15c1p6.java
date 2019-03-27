import java.util.*;
import java.io.*;
public class dmopc15c1p6 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static long[]seg;
	static long[]lazy;
	static long m;
	static StringTokenizer stt;
	public static void main(String[] args)throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		m=Long.parseLong(st.nextToken());
		int n=Integer.parseInt(st.nextToken()), q=Integer.parseInt(st.nextToken());
		seg=new long[n*3];lazy=new long[n*3];
		stt=new StringTokenizer(br.readLine());
		build(1,n,1);
		for(int i=0;i< q;i++){
			st=new StringTokenizer(br.readLine());
			int cmd=Integer.parseInt(st.nextToken()), l=Integer.parseInt(st.nextToken()), r=Integer.parseInt(st.nextToken());
			if(cmd==1){
				long v=Long.parseLong(st.nextToken());
				update(1,n,l,r,v,1);
			}else{
				System.out.println(query(1,n,l,r,1)%m);
			}
		}
	}
	static void build(int l,int r,int cur) throws IOException{
		if(l==r){
			seg[cur]=Integer.parseInt(stt.nextToken())%m;
			return;
		}
		int mid=(l+r)/2;
		build(l,mid,cur*2);build(mid+1,r,cur*2+1);
		seg[cur]=seg[cur*2]+seg[cur*2+1];
	}
	static void update(int cl, int cr,int l, int r, long v, int cur){
		if(lazy[cur]!=0){
			seg[cur]+=(cr-cl+1)*lazy[cur];
			if(cl!=cr){
				lazy[cur*2]+=lazy[cur];
				lazy[cur*2+1]+=lazy[cur];
			}
			lazy[cur]=0;
		}
		if(cl>r||cr<l){
			return;
		}
		if(cl>=l&&cr<=r){
			seg[cur]+=(cr-cl+1)*v;
			if(cl!=cr){
				lazy[cur*2+1]+=v;
				lazy[cur*2]+=v;
			}
			return;
		}
		int mid=(cr+cl)/2;
		update(cl, mid, l, r, v, cur*2);
		update(mid+1, cr, l, r, v, cur*2+1);
		seg[cur]=seg[cur*2]+seg[cur*2+1];
	}
	static long query(int cl, int cr,int l,int r, int cur){
		if(lazy[cur]!=0){
			seg[cur]+=(cr-cl+1)*lazy[cur];
			if(cl!=cr){
				lazy[cur*2]+=lazy[cur];
				lazy[cur*2+1]+=lazy[cur];
			}
			lazy[cur]=0;
		}
		if(cl>r||cr<l){
			return 0;
		}
		if(cl>=l&&cr<=r){
			return seg[cur];
		}
		int mid=(cr+cl)/2;
		return query(cl,mid, l, r, cur*2)+query(mid+1, cr, l, r, cur*2+1);
	}
}
