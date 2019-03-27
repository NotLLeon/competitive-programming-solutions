import java.util.*;
public class cco10p2 {
	static int [][]adj, dp;
	static int []wb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(), d=sc.nextInt();	
		wb=new int[n];
		adj=new int[n][2]; dp=new int[n][1000];
		for(int i=0;i<n;i++){
			Arrays.fill(adj[i], -1);
			Arrays.fill(dp[i], 99999);
			dp[i][300]=1;
		}
		for(int i=0;i<n;i++){
			int cur=sc.nextInt(), w=sc.nextInt(), c=sc.nextInt();
			for(int j=0;j<c;j++){
				adj[cur][j]=sc.nextInt();
			}
			if(w==0) wb[cur]=-1;
			else wb[cur]=1;
		}
		DFS(0);
		System.out.println(dp[0][300+d]==99999?-1:dp[0][300+d]);
	}
	static void DFS(int cur){
		if(adj[cur][0]==-1&&adj[cur][1]==-1){
			dp[cur][300+wb[cur]]=0;
			return;
		}
		int c1=adj[cur][0], c2=adj[cur][1],nc=0;
		if(c1!=-1&&c2!=-1)nc=1;
		for(int i=0;i<2;i++){
			int c=adj[cur][i];
			if(c!=-1){
				DFS(c);
				for(int j=0;j<601;j++){
					if(dp[c][j]!=99999){
						dp[cur][j+wb[cur]]=Math.min(dp[cur][j+wb[cur]], dp[c][j]+nc);
					}
				}
			}
		}
		
		if(c1!=-1&&c2!=-1){
			for(int j=0;j<601;j++){
				for(int l=0;l<601;l++){
					if(dp[c1][j]!=99999&&dp[c2][l]!=99999){
						dp[cur][wb[cur]+j+l-300]=Math.min(dp[cur][wb[cur]+j+l-300], dp[c1][j]+dp[c2][l]);
					}
				}
			}
		}
	}
}