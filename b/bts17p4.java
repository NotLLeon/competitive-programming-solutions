import java.io.*;
import java.util.*;
public class bts17p4 {
	//heap based dijkstra
	//couldve used proximityQueue instead ;(
	static int hsize=0;
	static node[]heap=new node[1000001];
	static class node{
		int val, ind;
		node(int a, int b){
			val=a;
			ind=b;
		}
	}
	static void insert(node n){
		if(hsize==heap.length){
			return;
		}
		hsize++;
		int i=hsize-1;
		heap[i]=n;
		while(i!=0&&heap[(i-1)/2].val>heap[i].val){
			node temp=heap[(i-1)/2]; 
			heap[(i-1)/2]=heap[i];
			heap[i]=temp;
			i=(i-1)/2;
		}
	}
	static node getMin(){
		if(hsize==0){
			return new node(999999999, -1);
		}else if(hsize==1){
			hsize--;
			return heap[0];
		}
		node root=heap[0];
		heap[0]=heap[hsize-1];
		hsize--;
		MinHeapify(0);
		return root;
	}
	static void MinHeapify(int i){
		int l = (i*2)+1;
		int r = (i*2)+2;
		int smallest = i;
		if (l < hsize && heap[l].val < heap[i].val)smallest = l;
		if (r < hsize && heap[r].val < heap[smallest].val) smallest = r;
		if (smallest != i){
			node temp=heap[smallest];
			heap[smallest]=heap[i];
			heap[i]=temp;
			MinHeapify(smallest);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken()), M=Integer.parseInt(st.nextToken()), J=Integer.parseInt(st.nextToken());
		int []adj=new int[N+2];
		for(int i=0;i<M;i++){
			st=new StringTokenizer(br.readLine());
			int p=Integer.parseInt(st.nextToken()), ti=Integer.parseInt(st.nextToken());
			adj[p]=ti;
		}
		for(int i=0;i<N+2;i++){
			if(adj[i]==0)adj[i]=-1;
		}
		adj[N+1]=0;
		if(N==0)System.out.println(0);
		else System.out.println(solve(adj, J));
	}
	public static int solve(int []adj, int j){
		int[]dis=new int[adj.length];
		boolean[]vis=new boolean[adj.length];
		dis[0]=0;
		vis[0]=true;
		node e=new node(0,0);
		insert(e);
		while(!vis[adj.length-1]&&hsize>0){
			node cur=getMin();
			int min=cur.val, ind=cur.ind;
			if(min==999999999){
				break;
			}
			for(int i=1;i<=j;i++){
				int pos=ind+i, neg=ind-i;
				if(pos>=adj.length){
					pos=adj.length-1;
				}
				if(neg<0){
					neg=0;
				}
				if(adj[pos]!=-1&&!vis[pos]){
					dis[pos]=Math.max(adj[pos], min);
					insert(new node(Math.max(adj[pos], min), pos));
					vis[pos]=true;
				}
				if(adj[neg]!=-1&&!vis[neg]){
					dis[neg]=Math.max(adj[neg], min);
					insert(new node(Math.max(adj[neg], min), neg));
					vis[neg]=true;
				}
			}
		}
		if(!vis[adj.length-1]){
			return -1;
		}else{
			return dis[adj.length-1];
		}
	}
}
