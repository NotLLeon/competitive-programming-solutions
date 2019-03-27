/*
ID: NotLeon
LANG: JAVA
TASK: dining
*/
import java.util.*;
import java.io.*;
public class dining {
	static class edge implements Comparable<edge>{
		int x;
		long d;
		edge(int a, long b){
			x=a;
			d=b;
		}
		public int compareTo(edge e){
			if(this.d<e.d)return -1;
			else return 1;
		}
	}
	static ArrayList<edge>[]adj;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("dining.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dining.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()), m=Integer.parseInt(st.nextToken()), k=Integer.parseInt(st.nextToken());
		adj=new ArrayList[n];
		for(int i=0;i<n;i++)adj[i]=new ArrayList<edge>();
		for(int i=0;i<m;i++){
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken())-1, b=Integer.parseInt(st.nextToken())-1;
			long w=Long.parseLong(st.nextToken());
			adj[a].add(new edge(b,w));
			adj[b].add(new edge(a,w));
		}
		PriorityQueue<edge>pq=new PriorityQueue<edge>();
		long []dis=new long[n];
		Arrays.fill(dis, Long.MAX_VALUE);
		dis[n-1]=0;
		pq.add(new edge(n-1,0));
		while(!pq.isEmpty()){
			edge ce=pq.poll();
			int cur=ce.x;
			for(edge i:adj[cur]){
				if(i.d+dis[cur]<dis[i.x]){
					dis[i.x]=i.d+dis[cur];
					pq.add(new edge(i.x, dis[i.x]));
				}
			}
		}
		long[]ym=new long[n], wy=new long[n];
		pq=new PriorityQueue<edge>();
		long[]best=new long[n];
		Arrays.fill(best, Long.MAX_VALUE);
		for(int i=0;i<k;i++){
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken())-1;
			long y=Long.parseLong(st.nextToken());
			ym[a]=y;
			wy[a]=y;
			best[a]=dis[a]-ym[a];
			pq.add(new edge(a,best[a]));
		}
		while(!pq.isEmpty()){
			edge ce=pq.poll();
			int cur=ce.x;
			for(edge i:adj[cur]){
				if(i.d+best[cur]<best[i.x]){
					wy[i.x]=wy[cur];
					best[i.x]=i.d+best[cur];
					pq.add(new edge(i.x, best[i.x]));
				}
			}
		}
		for(int i=0;i<n-1;i++){
			if(best[i]<=dis[i])out.println(1);
			else out.println(0);
		}
		out.close();
	}

}