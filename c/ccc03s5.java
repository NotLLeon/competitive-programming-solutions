import java.util.*;
public class ccc03s5 {
	static class node implements Comparable<node>{
		int ind, w;
		node(int a, int b){
			ind=a;w=b;
		}
		public int compareTo(node e){
			return e.w-this.w;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c=sc.nextInt(), r=sc.nextInt(), d=sc.nextInt();
		ArrayList<node>[]adj=new ArrayList[c];
		for(int i=0;i<c;i++)adj[i]=new ArrayList<node>();
		for(int i=0;i<r;i++){
			int x=sc.nextInt()-1, y=sc.nextInt()-1, w=sc.nextInt();
			adj[x].add(new node(y,w));
			adj[y].add(new node(x,w));
		}
		boolean []des=new boolean[c], vis=new boolean[c];
		for(int i=0;i<d;i++)des[sc.nextInt()-1]=true;
		PriorityQueue<node>pq=new PriorityQueue<node>();
		int cnt=d, min=0;
		pq.add(new node(0,Integer.MAX_VALUE));
		while(cnt>0){
			node cur=pq.poll();
			if(vis[cur.ind])continue;
			vis[cur.ind]=true;
			if(des[cur.ind])cnt--;
			min=cur.w;
			for(node i:adj[cur.ind]){
				if(!vis[i.ind])pq.add(new node(i.ind, Math.min(i.w,cur.w)));
			}
		}
		System.out.println(min);

	}

}
