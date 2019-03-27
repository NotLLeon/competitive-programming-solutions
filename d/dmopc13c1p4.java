import java.util.*;
import java.io.*;
public class dmopc13c1p4 {

	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		for(int o=0;o<n;o++){
			StringTokenizer st= new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken()), y=Integer.parseInt(st.nextToken());
			int [][]m={{1,0}, {-1, 0}, {0, 1}, {0, -1}};
			char[][]adj=new char[y][x];
			int [][]vis=new int[y][x];
			for(int i=0;i<y;i++){
				for(int j=0;j<x;j++){
					vis[i][j]=-1;
				}
			}
			Queue <Integer>q=new LinkedList<Integer>();
			for(int i=0;i<y;i++){
				String s=br.readLine().trim();
				for(int j=0;j<x;j++){
					adj[i][j]=s.charAt(j);
					if(adj[i][j]=='C'){
						q.add(i);q.add(j);
						vis[i][j]=0;
					}
				}
			}
			int max=-5;
			boolean flag=false;
			while(true){
				int cury=q.poll(),curx=q.poll();
				for(int i=0;i<m.length;i++){
				if(cury+m[i][0]<y&&cury+m[i][0]>-1&&curx+m[i][1]<x&&curx+m[i][1]>-1){
					if(vis[cury+m[i][0]][curx+m[i][1]]==-1){
						if(adj[cury+m[i][0]][curx+m[i][1]]=='O'||adj[cury+m[i][0]][curx+m[i][1]]=='W'){
							vis[cury+m[i][0]][curx+m[i][1]]= vis[cury][curx]+1;
							if(vis[cury+m[i][0]][curx+m[i][1]]<60){
								q.add(cury+m[i][0]);q.add(curx+m[i][1]);
								if(adj[cury+m[i][0]][curx+m[i][1]]=='W'){
									System.out.println(vis[cury+m[i][0]][curx+m[i][1]]);
									flag=true;
									break;
								}
							}
						}
					}
				}
				}
				if(flag){
					break;
				}
				if(q.isEmpty()){
					System.out.println("#notworth");
					break;
				}
			}
		}
	}
}