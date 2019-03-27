import java.util.*;
import java.io.*;
public class nccc6s5 {
	static class node implements Comparable<node>{
		int ind, w, prev;
		node(int a, int b, int c){
			ind=a;w=b;prev=c;
		}
		public int compareTo(node e){
			return this.w-e.w;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()), m=Integer.parseInt(st.nextToken());
		ArrayList<node>[]adj=new ArrayList[n];
		int[]lvl=new int[n];
		int [][]LCA=new int[n][(int)(Math.ceil(Math.log(n)/Math.log(2)))+1];
		int[][]ans=new int[n][(int)(Math.ceil(Math.log(n)/Math.log(2)))+1];
		for(int i=0;i<n;i++){
			adj[i]=new ArrayList<node>();
			Arrays.fill(ans[i], -1);
		}
		for(int i=0;i<m;i++){
			st=new StringTokenizer(br.readLine());
			int n1=Integer.parseInt(st.nextToken())-1, n2=Integer.parseInt(st.nextToken())-1, w=Integer.parseInt(st.nextToken());
			adj[n1].add(new node(n2,w,-1));
			adj[n2].add(new node(n1,w,-1));
		}
		int q=Integer.parseInt(br.readLine());
		PriorityQueue<node>pq=new PriorityQueue<node>();
		boolean[]vis=new boolean[n];
		Queue<node>Q=new LinkedList<node>();
		vis[0]=true;
		Q.add(new node(0,0,-1));
		while(!Q.isEmpty()){
			node cur=Q.poll();
			for(node nxt:adj[cur.ind]){
				if(vis[nxt.ind])continue;
				vis[nxt.ind]=true;
				lvl[nxt.ind]=lvl[cur.ind]+1;
				ans[nxt.ind][0]=nxt.w;
				LCA[nxt.ind][0]=cur.ind;
				Q.add(nxt);
			}
		}
		for(int i=0;i<(int)(Math.ceil(Math.log(n)/Math.log(2)));i++){
			for(int j=0;j<n;j++){
				if(LCA[j][i]==-1)continue;
				LCA[j][i+1]=LCA[LCA[j][i]][i];
				if(LCA[j][i+1]!=-1){
					ans[j][i+1]=ans[LCA[j][i]][i]+ans[j][i];
				}
			}
		}
		for(int i=0;i<q;i++){
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken())-1, y=Integer.parseInt(st.nextToken())-1;
			long total=0;
			if(lvl[x]<lvl[y]){
				int temp=x;
				x=y;
				y=temp;
			}
			int diff=lvl[x]-lvl[y];
			for (int j=0; j<(int)(Math.ceil(Math.log(n)/Math.log(2)))+1; j++){
				if (((diff>>j)&1)!=0){
					total+=ans[x][j];
					x=LCA[x][j];
				}
			}
			int x1=x, y1=y;
			int lca=0;
			if(x==y)lca=x;
			else{
				for(int j=(int)(Math.ceil(Math.log(n)/Math.log(2)));j>=0;j--){
					if(LCA[x][j]!=LCA[y][j]){
						x=LCA[x][j];
						y=LCA[y][j];
					}
				}
				lca=LCA[x][0];
			}
			diff=lvl[x1]-lvl[lca];
			for (int j=0; j<(int)(Math.ceil(Math.log(n)/Math.log(2)))+1; j++){
				if (((diff>>j)&1)!=0){
					total+=ans[x1][j];
					total+=ans[y1][j];
					x1=LCA[x1][j];
					y1=LCA[y1][j];
				}
			}
			System.out.println(total);
		}
	}
}