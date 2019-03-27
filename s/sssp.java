import java.util.*;
public class sssp {
	static class node implements Comparable<node>{
		int ind, w;
		node(int a, int b){
			ind=a;w=b;
		}
		public int compareTo(node e){
			if(this.w < e.w)return -1;
			else if(this.w > e.w)return 1;
			else return 0;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(), m=sc.nextInt();
		ArrayList<node>[]adj=new ArrayList[n];
		for(int i=0;i<n;i++)adj[i]=new ArrayList<node>();
		for(int i=0;i<m;i++){
			int a=sc.nextInt()-1, b=sc.nextInt()-1, w=sc.nextInt();
			adj[a].add(new node(b,w));
			if(a!=b)adj[b].add(new node(a,w));
		}
		boolean[]vis=new boolean[n];
		int []dis=new int[n];
		PriorityQueue<node>q=new PriorityQueue<node>();
		q.add(new node(0,0));
		while(!q.isEmpty()){
			node cur=q.poll();
			if(vis[cur.ind])continue;
			vis[cur.ind]=true;
			dis[cur.ind]=cur.w;
			for(node i:adj[cur.ind]){
				q.add(new node(i.ind, cur.w+i.w));
			}
		}
		for(int i=0;i<n;i++){
			if(vis[i])System.out.println(dis[i]);
			else System.out.println(-1);
		}
	}

}
