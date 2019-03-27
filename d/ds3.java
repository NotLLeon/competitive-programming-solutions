import java.util.*;
import java.io.*;
public class ds3 {
	//build a Min and GCF segment tree
	//rewrite build seg
	static class node{
		int hi, lo, mid, key;
		node(int a, int b, int c, int d){
			hi=a;
			lo=b;
			mid=c;
			key=d;
		}
	}
	static int n;
	static node[]minseg;
	static node[]seg;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken()); int m=Integer.parseInt(st.nextToken());
		minseg=new node[n*2-1];seg=new node[n*2-1];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n*2-1;i++){
			minseg[i]=new node(i,i,i,-1);
			seg[i]=new node(i,i,i,-1);
		}
		for(int i=0;i<n;i++){
			int x=Integer.parseInt(st.nextToken());
			minseg[n-1+i].key=x; seg[n-1+i].key=x;
		}
		build(0,n-1, 0);
		for(int i=0;i<m;i++){
			for(int j=0;j<seg.length;j++){
				System.out.println(minseg[j].key);
			}
			st= new StringTokenizer(br.readLine());
			String s=st.nextToken();
			if(s.equals("C")){
				int x=Integer.parseInt(st.nextToken())-1, y=Integer.parseInt(st.nextToken());
//				update(x,y);
			}
		}
	}
	public static int GCF(int a,int b){
		while (b > 0){
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
	public static void build(int l, int r, int num){
		seg[num].lo = l; minseg[num].lo=l;
		seg[num].hi = r; minseg[num].hi=r;
		seg[num].mid = (l + r) / 2;	minseg[num].mid = (l + r) / 2;
		if (l!= r){
			build(l, seg[num].mid, 2 * num);
			build(seg[num].mid+1, r, 2 * num +1);
		}
		seg[num].key=GCF(seg[2*(num)].key,seg[2*(num)].key);
		minseg[num].key=Math.min(minseg[2*(num+1)-1].key, minseg[2*(num+1)].key);
	}
	public static void update(int x, int y){
		int i=n-2+x;
		while(i!=0){
			minseg[i].key=Math.min(minseg[i*2-1].key, minseg[i*2-2].key);
			minseg[i].lo=minseg[i*2-2].lo;minseg[i].hi=minseg[i*2-1].hi;
			seg[i].key=GCF(seg[i*2-1].key, seg[i*2-2].key);
			seg[i].lo=seg[i*2-2].lo;seg[i].hi=seg[i*2-1].hi;
			i=i/2;
		}
	}
}
