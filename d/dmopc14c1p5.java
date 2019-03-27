import java.util.*;
import java.io.*;
public class dmopc14c1p5 {
	public static class Point{
		int r, c;
		Point(int r0, int c0){
			r = r0;
			c = c0;
		}
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int [][]m={{1,0}, {-1, 0}, {0, 1}, {0, -1}};
		StringTokenizer st=new StringTokenizer(br.readLine());
		int r=Integer.parseInt(st.nextToken()), c=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int s1=Integer.parseInt(st.nextToken()), s2=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int d1=Integer.parseInt(st.nextToken()), d2=Integer.parseInt(st.nextToken());
		char [][]adj=new char[r][c];
		int[][]vis=new int[r][c];
		for(int i=0;i<r;i++){
			String s=br.readLine();
			for(int j=0;j<c;j++){
				adj[i][j]=s.charAt(j);
				vis[i][j]=-1;
			}
		}
		int t=Integer.parseInt(br.readLine());
		Point[]te=new Point[t];
		for(int i=0;i<t;i++){
			st=new StringTokenizer(br.readLine());
			te[i]=new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Queue<Point>q=new LinkedList<Point>();
		q.add(new Point(s1, s2));
		int min=999;
		vis[s1][s2]=0;
		while(!q.isEmpty()){
			Point cur=q.poll();
			for(int i=0;i<m.length;i++){
				int xy=cur.r+m[i][0], yx=cur.c+m[i][1];
				if(xy<r&&xy>-1&&yx<c&&yx>-1){
					if(vis[xy][yx]==-1&&adj[xy][yx]=='O'){
						vis[xy][yx]=vis[cur.r][cur.c]+1;
						Point ad=new Point(xy, yx);
						q.add(ad);
					}
				}
			}
			if(vis[d1][d2]!=-1){
				for(int k=0;k<te.length;k++){
					if(vis[te[k].r][te[k].c]!=-1&&vis[te[k].r][te[k].c]<min){
						min=vis[te[k].r][te[k].c];
					}
				}
				if(vis[d1][d2]-min<0){
					System.out.println(0);
				}else{
					System.out.println(vis[d1][d2]-min);
				}
				break;
			}
		}

	}
}