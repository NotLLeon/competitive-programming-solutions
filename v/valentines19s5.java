import java.util.*;
import java.io.*;
public class valentines19s5 {
	static int n,q, prev;
	static boolean[][]adj;
	public static void main(String[] args)throws IOException {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt(); q=sc.nextInt();
		adj=new boolean[n][n];
		for(int i=0;i<n-1;i++){
			int a=sc.nextInt()-1, b=sc.nextInt()-1;
			adj[a][b]=adj[b][a]=true;
		}
		for(int i=0;i<q;i++){
			int v=sc.nextInt(), k=sc.nextInt(), p=sc.nextInt()-1;
			prev=-1;
			boolean w=true;
			for(int j=0;j<k-1;j++){
				int n=sc.nextInt()-1;
				if(!bfs(p,n))w=false;
				p=n;
			}
			System.out.println(w?1:0);
		}
	}
	static boolean bfs(int s, int e){
		Queue<Integer>q=new LinkedList<Integer>();
		q.add(s);
		boolean[]vis=new boolean[n];
		vis[s]=true;
		while(!q.isEmpty()){
			int cur=q.poll();
			for(int i=0;i<n;i++){
				if(!vis[i]&&adj[cur][i]&&i!=prev){
					if(i==e)prev=cur;
					vis[i]=true;
					q.add(i);
				}
			}
		}
		return vis[e];
	}
}
