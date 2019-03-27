import java.util.*;
public class dmopc14ce1p4 {
	static int v,e;
	static LinkedList<edge>[]adj;
	static double[][]dis;
	static class edge implements Comparable<edge>{
		int des;
		double v,d,t;
		edge(int a, double b, double c){
			des=a;v=b;d=c;
			t=d/v;
		}
		public int compareTo(edge e){
			return this.t>e.t?1:-1;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		v=sc.nextInt();
		e=sc.nextInt();
		adj=new LinkedList[v];
		for(int i=0;i<v;i++)adj[i]=new LinkedList<edge>();
		while(e-->0){
			int m=sc.nextInt()-1, n=sc.nextInt()-1, d=sc.nextInt(), s=sc.nextInt();
			adj[m].add(new edge(n,s,d));
			adj[n].add(new edge(m,s,d));
		}
		PriorityQueue<edge>pq=new PriorityQueue<edge>();
		dis=new double[v][2];
		for(int i=0;i<v;i++)dis[i][0]=Integer.MAX_VALUE;
		dis[0][0]=0;
		int[]least=new int[v];
		pq.add(new edge(0,0,0));
		while(!pq.isEmpty()){
			edge cur=pq.poll();
			for(edge e:adj[cur.des]){
				if(dis[e.des][0]>dis[cur.des][0]+e.t||
						(dis[e.des][0]==dis[cur.des][0]+e.t)&&least[e.des]>least[cur.des]+1){
					dis[e.des][0]=dis[cur.des][0]+e.t;
					dis[e.des][1]=dis[cur.des][1]+e.d/(0.75*e.v);
					least[e.des]=least[cur.des]+1;
					pq.add(e);
				}
			}
		}
		System.out.println(least[v-1]);
		System.out.println(Math.round((dis[v-1][1]-dis[v-1][0])*60));
		

	}

}
