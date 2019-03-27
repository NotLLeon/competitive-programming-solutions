import java.util.*;
import java.io.*;
public class ccoprep1p3 {
	static int n,m;
	static int[]nr,siz;
	static Node[]ts;
	static class Node{
		int key, rank, ran, sz;
		Node left,right,par;
		boolean del;
		Node(int a, int b){
			key=a;
			rank=b;
			del=false;
			ran=(int) (Math.random()*Integer.MAX_VALUE);
			if(key!=-1)nr[key]=key;
			sz=1;
		}
		public String toString(){
			String ts=key+" "+sz+" ";
			if(left!=null)ts+="("+left+")"+" ";
			else ts+="nll ";
			if(right!=null)ts+="("+right+")"+" ";
			else ts+="nll ";
			return ts;
		}
	}
	static void insert(Node par,Node n){
		par.sz++;
		if(n.rank>par.rank){
			if(par.right!=null)insert(par.right, n);
			else{
				par.right=n;
				n.par=par;
			}
			if(par.right.ran>par.ran)rotateLeft(par.right);
		}else{
			if(par.left!=null)insert(par.left, n);
			else{
				par.left=n;
				n.par=par;
			}
			if(par.left.ran>par.ran)rotateRight(par.left);
		}
	}
	static void delete(Node n){
		if(n.right==null&&n.left==null){
			if(n.par.left!=null&&n.par.left==n)n.par.left=null;
			else n.par.right=null;
			return;
		}
		if(n.left!=null&&n.right!=null){
			if(n.left.ran<n.right.ran)rotateRight(n.left);
			else rotateLeft(n.right);
		}else if(n.left!=null)rotateRight(n.left);
		else rotateLeft(n.right);
		delete(n);
	}
	static void rotateRight(Node n){
		Node r=n.right,p=n.par,gp=p.par;
		replace(gp,p,n);
		n.par=gp;
		p.par=n;
		n.right=p;
		p.left=r;
		if(r!=null)r.par=p;
		setSz(p);
		setSz(n);
	}
	static void rotateLeft(Node n){
		Node l=n.left,p=n.par,gp=p.par;
		replace(gp,p,n);
		p.par=n;
		n.left=p;
		p.right=l;
		if(l!=null)l.par=p;
		setSz(p);
		setSz(n);
	}
	static void replace(Node p, Node o, Node n){
		if(p!=null){
			if(p.left!=null&&p.left==o)p.left=n;
			else p.right=n;
		}
		if(n!=null)n.par=p;
	}
	static int getRank(Node n, int rank, int prev){
		if(lCount(n)+prev==rank)return n.key+1;
		if(lCount(n)+prev>rank){
			if(n.left==null)return -1;
			return getRank(n.left, rank, prev);
		}
		if(n.right==null)return -1;
		return getRank(n.right,rank,prev+lCount(n)+1);
	}
	static int lCount(Node n){
		if(n.left==null)return 0;
		return n.left.sz;
	}
	static void setSz(Node n){
		if(n==null)return;
		n.sz=n.del?0:1;
		if(n.left!=null)n.sz+=n.left.sz;
		if(n.right!=null)n.sz+=n.right.sz;
		if(n.key!=-1)siz[n.key]=n.sz;
	}
	static Node[] split(Node n,int val){
		Node du=new Node(0,val);
		du.ran=Integer.MAX_VALUE-1;
		insert(n,du);
		Node[]ans={du.left,du.right};
		du.del=true;
		delete(du);
		return ans;
	}
	static void merge(int a1, int b1){
		Node a=ts[a1].right, b=ts[b1].right;
		if(a.ran<b.ran)merge(b1,a1);
		else{
			ts[a1].right=mergeh(a, b);
			nr[b1]=a1;
			ts[b1].right=null;
		}
	}
	static Node mergeh(Node a, Node b){ 
		if(a==null)return b;
		else if(b==null)return a;
		System.out.println(a.key+" "+b.key);
		if(a.ran<b.ran)return mergeh(b,a);
		b.par=a;
		Node []spl=split(b.par,a.key);
		a.left=mergeh(a.left, spl[0]);
		a.right=mergeh(a.right, spl[1]);
		setSz(a);
		return a;
	}
	static int getPar(int a){
		if(nr[a]==a)return a;
		nr[a]=getPar(nr[a]);
		return nr[a];
	}
	static boolean sPar(int a, int b){
		return getPar(a)==getPar(b);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken()); m=Integer.parseInt(st.nextToken());
		int[]rs=new int[n];
		ts=new Node[n];
		nr=new int[n];
		siz=new int[n];
		Arrays.fill(siz, 1);
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			rs[i]=Integer.parseInt(st.nextToken());
			ts[i]=new Node(-1,-1);
			ts[i].ran=Integer.MAX_VALUE;
			ts[i].right=new Node(i,rs[i]);
			ts[i].right.par=ts[i];
		}
		int a, b;
		for(int i=0;i<m;i++){
			st=new StringTokenizer(br.readLine());
			a=Integer.parseInt(st.nextToken())-1; b=Integer.parseInt(st.nextToken())-1;
			if(!sPar(a,b)){
				merge(getPar(a),getPar(b));
			}
		}
		int q=Integer.parseInt(br.readLine());
		char cmd;
		for(int i=0;i<q;i++){
			st=new StringTokenizer(br.readLine());
			cmd=st.nextToken().charAt(0);
			a=Integer.parseInt(st.nextToken())-1;b=Integer.parseInt(st.nextToken());
			if(cmd=='B'){
				b--;
				if(!sPar(a,b))merge(getPar(a),getPar(b));
			}else {
				System.out.println(getRank(ts[getPar(a)].right,b-1,0));
			}
		}
		System.out.println(ts[0].right);
		System.out.println(ts[1].right);
		System.out.println(ts[2].right);
		for(int i=0;i<n;i++)System.out.print(getPar(i)+" ");
	}
}