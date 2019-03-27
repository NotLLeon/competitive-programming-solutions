import java.util.*;
public class dwite10c5p5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=0;tc<5;tc++){
			int n=sc.nextInt(),m=sc.nextInt();
			int[][]adj=new int[n][m];
			for(int i=0;i<n;i++){
				for(int j=0;j<m;j++)adj[i][j]=sc.nextInt();
			}
			int ans=0;
			int[][]mv={{-1,0},{0,-1},{0,1},{1,0}};
			for(int i=0;i<n;i++){
				pt1:
					for(int j=0;j<m;j++){
						int d=adj[i][j], min=Integer.MAX_VALUE;
						boolean[][]vis=new boolean[n][m];
						vis[i][j]=true;
						Queue<Integer>q=new LinkedList<Integer>();
						LinkedList<Integer>con=new LinkedList<Integer>();
						q.add(i);q.add(j);
						con.add(i);con.add(j);
						while(!q.isEmpty()){
							int ci=q.poll(), cj=q.poll();
							for(int k=0;k<4;k++){
								int ni=ci+mv[k][0], nj=cj+mv[k][1];
								if(ni>-1&&ni<n&&nj>-1&&nj<m){
									if(!vis[ni][nj]){
										vis[ni][nj]=true;
										if(adj[ni][nj]>d)min=Math.min(min, adj[ni][nj]);
										else{
											q.add(ni);
											q.add(nj);
											con.add(ni);
											con.add(nj);
										}
									}
								}else{
									continue pt1;
								}
							}
						}
						while(!con.isEmpty()){
							int ci=con.poll(), cj=con.poll();
							ans+=min-adj[ci][cj];
							adj[ci][cj]=min;
						}
					}
			}
			System.out.println(ans);
		}
	}

}
