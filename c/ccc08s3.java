import java.util.*;
public class ccc08s3 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int t=sc.nextInt();
		int w[][]={{0,1}, {0,-1}, {1, 0}, {-1, 0}};
		for(int o=0;o<t;o++){
			int r=sc.nextInt(), c=sc.nextInt();
			int [][]dis=new int[r][c];
			char[][]adj=new char[r][c];
			for(int i=0;i<r;i++){
				String s=sc.next();
				for(int j=0;j<c;j++){
					adj[i][j]=s.charAt(j);
					dis[i][j]=-1;
				}
			}
			Queue<Integer>q=new LinkedList<Integer>();
			q.add(0);q.add(0);
			dis[0][0]=1;
			if(dis[0][0]=='*'){
				System.out.println("-1");
				break;
			}
			while(true){
				int curr=q.poll(), curc=q.poll();
				if(adj[curr][curc]=='+'){
					for(int i=0;i<4;i++){
						int rc=curr+w[i][0], cr=curc+w[i][1];
						if(rc<r&&rc>-1&&cr<c&&cr>-1){
							if(dis[rc][cr]==-1){
								if(adj[rc][cr]=='+'||adj[rc][cr]=='-'||adj[rc][cr]=='|'){
									dis[rc][cr]=dis[curr][curc]+1;
									q.add(rc);q.add(cr);
								}
							}
						}
					}
				}else if(adj[curr][curc]=='-'){
					for(int i=0;i<2;i++){
						int rc=curr+w[i][0], cr=curc+w[i][1];
						if(rc<r&&rc>-1&&cr<c&&cr>-1){
							if(dis[rc][cr]==-1){
								if(adj[rc][cr]=='+'||adj[rc][cr]=='-'||adj[rc][cr]=='|'){
									dis[rc][cr]=dis[curr][curc]+1;
									q.add(rc);q.add(cr);
								}
							}
						}
					}
				}else if(adj[curr][curc]=='|'){
					for(int i=2;i<4;i++){
						int rc=curr+w[i][0], cr=curc+w[i][1];
						if(rc<r&&rc>-1&&cr<c&&cr>-1){
							if(dis[rc][cr]==-1){
								if(adj[rc][cr]=='+'||adj[rc][cr]=='-'||adj[rc][cr]=='|'){
									dis[rc][cr]=dis[curr][curc]+1;
									q.add(rc);q.add(cr);
								}
							}
						}
					}
				}
				if(dis[r-1][c-1]!=-1){
					System.out.println(dis[r-1][c-1]);
					break;
				}else if(q.isEmpty()){
					System.out.println("-1");
					break;
				}
			}
		}

	}

}
