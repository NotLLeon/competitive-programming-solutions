import java.io.*;
import java.util.*;
public class bts17p4v2 {

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
		adj[N+1]=-1;
		System.out.println(solve(adj, J));
	}
	public static int solve(int []adj, int j){
		int[]dis=new int[adj.length];
		for(int i=0;i<dis.length;i++){
			dis[i]=999999999;
		}
		boolean[]vis=new boolean[adj.length];
		dis[0]=0;
		vis[0]=true;
		while(!vis[adj.length-1]){
			int min=999999999; int ind=-1;
			for(int i=0;i<dis.length;i++){
				if(dis[i]<min){
					min=dis[i];
					ind=i;
				}
			}
			if(min==999999999){
				break;
			}
			dis[ind]=999999999;
			for(int i=1;i<=j;i++){
				int pos=ind+i, neg=ind-i;
				if(pos>=adj.length){
					pos=adj.length-1;
				}
				if(neg<0){
					neg=0;
				}
				if(adj[pos]!=0&&!vis[pos]){
					dis[pos]=Math.max(adj[pos], min);
					vis[pos]=true;
				}
				if(adj[neg]!=0&&!vis[neg]){
					dis[neg]=Math.max(adj[neg], min);
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