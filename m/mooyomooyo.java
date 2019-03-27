/*
ID: NotLeon
LANG: JAVA
TASK: mooyomooyo
 */
import java.util.*;
import java.io.*;
public class mooyomooyo {
	static int[][]adj;
	static int n, k;
	static int[][]m={{-1,0},{0,-1},{0,1},{1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("mooyomooyo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mooyomooyo.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken()); k=Integer.parseInt(st.nextToken());
		adj=new int[n][10];
		for(int i=0;i<n;i++){
			String s=br.readLine();
			for(int j=0;j<10;j++)adj[i][j]=s.charAt(j)-48;
		}
		do gravity(); while(change());
		for(int i=0;i<n;i++){
			for(int j=0;j<10;j++)out.print(adj[i][j]);
			out.println();
		}
		out.close();
	}
	static boolean change(){
		boolean cg=false;
		boolean[][]vis=new boolean[n][10];
		for(int i=0;i<n;i++){
			for(int j=0;j<10;j++){
				if(vis[i][j]||adj[i][j]==0)continue;
				int cc=adj[i][j], sz=1;
				Queue<Integer>q=new LinkedList<Integer>();
				vis[i][j]=true;
				q.add(i);q.add(j);
				LinkedList<Integer>con=new LinkedList<Integer>();
				while(!q.isEmpty()){
					int ci=q.poll(), cj=q.poll();
					con.add(ci);
					con.add(cj);
					for(int k=0;k<4;k++){
						int ni=ci+m[k][0], nj=cj+m[k][1];
						if(ni>-1&&ni<n&&nj>-1&&nj<10&&!vis[ni][nj]&&adj[ni][nj]==cc){
							sz++;
							vis[ni][nj]=true;
							q.add(ni);
							q.add(nj);
						}
					}
				}
				if(sz>=k){
					cg=true;
					while(!con.isEmpty())adj[con.poll()][con.poll()]=0;
				}
			}
		}
		return cg;
	}
	static void gravity(){
		for(int j=0;j<10;j++){
			for(int i=n-2;i>=0;i--){
				if(adj[i][j]!=0){
					for(int k=n-1;k>i;k--){
						if(adj[k][j]==0){
							adj[k][j]=adj[i][j];
							adj[i][j]=0;
							break;
						}
					}
				}
			}
		}
	}
}