import java.io.*;
import java.util.*;
public class bfs17p3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken()), M=Integer.parseInt(st.nextToken());
		int [][]adj=new int[N][4];
		int inds=-1, indf=-1, y1=-1;
		for(int i=0;i<N;i++){
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken()), y=Integer.parseInt(st.nextToken()), m=Integer.parseInt(st.nextToken());
			adj[i][0]=x;adj[i][1]=y;adj[i][2]=m;adj[i][3]=-1;
			if(y>y1){
				inds=i;
				y1=y;
			}
			if(m==9001){
				indf=i;
			}
		}
		adj[inds][3]=0;
		int ans1=solve(adj, N, inds, indf);
		int[][]adj1=new int[M][4];
		inds=-1; indf=-1; y1=-1;
		for(int i=0;i<M;i++){
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken()), y=Integer.parseInt(st.nextToken()), m=Integer.parseInt(st.nextToken());
			adj1[i][0]=x;adj1[i][1]=y;adj1[i][2]=m;adj1[i][3]=-1;
			if(y>y1){
				inds=i;
				y1=y;
			}
			if(m==9001){
				indf=i;
			}
		}
		adj1[inds][3]=0;
		int ans2=solve(adj1, M, inds, indf);
		if(ans1==-1&&ans2!=-1){
			System.out.println(":'(");
		}else if(ans1!=-1&&ans2==-1){
			System.out.println("We are the champions!");
		}else if(ans1<ans2){
			System.out.println("We are the champions!");
		}else if(ans2<ans1){
			System.out.println(":'(");
		}else{
			System.out.println("SUDDEN DEATH");
		}
	}
	static int solve(int[][]adj, int n, int inds, int indf){
		Queue <Integer>q=new LinkedList<Integer>();
		q.add(inds);
		while(!q.isEmpty()&&adj[indf][3]==-1){
			int ind=q.poll(), val=adj[ind][2];
			for(int l=0;l<n;l++){
				if(adj[l][3]==-1){
					double dis=Math.sqrt(Math.pow(Math.abs((double)(adj[ind][0]-adj[l][0])), 2)+Math.pow(Math.abs((double)(adj[ind][1]-adj[l][1])), 2));
					if(dis<=(double)val){
						q.add(l);
						adj[l][3]=adj[ind][3]+1;
					}
				}
			}
		}
		return adj[indf][3];
	}
}
