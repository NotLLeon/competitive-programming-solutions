import java.util.*;
import java.io.*;
public class lkp18c2p6 {
	static class edge{
		int to;
		long d;
		edge(int a, long b){
			to=a;
			d=b;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()),m=Integer.parseInt(st.nextToken()), k=Integer.parseInt(st.nextToken());
		int[]im=new int[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<k;i++)im[Integer.parseInt(st.nextToken())-1]=1;
		ArrayList<edge>[]adj=new ArrayList[n];
		for(int i=0;i<n;i++)adj[i]=new ArrayList<edge>();
		int[]deg=new int[n];
		for(int i=0;i<n-1;i++){
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken())-1, b=Integer.parseInt(st.nextToken())-1;
			long w=Long.parseLong(st.nextToken());
			adj[a].add(new edge(b,w));
			deg[a]++;
			deg[b]++;
			adj[b].add(new edge(a,w));
		}
		Queue<Integer>q=new LinkedList<Integer>();
		for(int i=0;i<n;i++){
			if(im[i]!=1&&deg[i]==1){
				im[i]=-1;
				q.add(i);
			}
		}
		while(!q.isEmpty()){
			int cur=q.poll();
			for(edge i:adj[cur]){
				deg[i.to]--;
				if(im[i.to]==0&&deg[i.to]==1){
					im[i.to]=-1;
					deg[i.to]--;
					q.add(i.to);
				}
			}
		}
		long tot=0;
		q=new LinkedList<Integer>();
		boolean[]vis=new boolean[n];
		for(int i=0;i<n;i++){
			if(im[i]!=-1){
				vis[i]=true;
				q.add(i);
				break;
			}
		}
		while(!q.isEmpty()){
			int cur=q.poll();
			for(edge i:adj[cur]){
				if(im[i.to]!=-1&&!vis[i.to]){
					vis[i.to]=true;
					tot+=i.d;
					q.add(i.to);
				}
			}
		}
		System.out.println(tot);
		
	}

}
