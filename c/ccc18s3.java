import java.util.*;
import java.io.*;
public class ccc18s3 {
	static int adj[][];
	static class node implements Comparable<node>{
		int x, y, dis;
		node(int a, int b, int c){
			x=a;y=b;dis=c;
		}
		public int compareTo(node e){
			if(this.dis==e.dis){
				if(adj[this.x][this.y]>=1)return -1;
				else return 1;
			}
			return this.dis-e.dis;
		}
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int x=sc.nextInt(), y=sc.nextInt(), sx=0, sy=0;
		adj=new int[x][y];
		boolean [][]open=new boolean[x][y];
		sc.nextLine();
		LinkedList<Integer>cams=new LinkedList<Integer>();
		for(int i=0;i<x;i++){
			String s=sc.nextLine();
			for(int j=0;j<y;j++){
				if(s.charAt(j)=='.')open[i][j]=true;
				else if(s.charAt(j)=='W')adj[i][j]=-1;
				else if(s.charAt(j)=='C'){
					cams.add(i);cams.add(j);
				}else if(s.charAt(j)=='S'){
					sx=i;sy=j;
				}else if(s.charAt(j)=='L')adj[i][j]=1;
				else if(s.charAt(j)=='R')adj[i][j]=2;
				else if(s.charAt(j)=='U')adj[i][j]=3;
				else if(s.charAt(j)=='D')adj[i][j]=4;
			}
		}
		int [][]dis=new int[x][y];
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){
				dis[i][j]=-1;
			}
		}
		while(!cams.isEmpty()){
			int xc=cams.poll(), yx=cams.poll();
			for(int i=0;i<x;i++){
				if(adj[xc+i][yx]!=-1&&adj[xc+i][yx]<1)adj[xc+i][yx]=-2;
				else if(adj[xc+i][yx]==-1)break;
			}
			for(int i=0;i<x;i++){
				if(adj[xc-i][yx]!=-1&&adj[xc-i][yx]<1)adj[xc-i][yx]=-2;
				else if(adj[xc-i][yx]==-1)break;
			}
			for(int i=0;i<y;i++){
				if(adj[xc][yx+i]!=-1&&adj[xc][yx+i]<1)adj[xc][yx+i]=-2;
				else if(adj[xc][yx+i]==-1) break;
			}
			for(int i=0;i<y;i++){
				if(adj[xc][yx-i]!=-1&&adj[xc][yx-i]<1)adj[xc][yx-i]=-2;
				else if(adj[xc][yx-i]==-1)break;
			}
		}
		dis[sx][sy]=0;
		int [][]mv={{0,1},{0,-1},{-1,0},{1,0}};
		PriorityQueue<node>pq=new PriorityQueue<node>();
		pq.add(new node(sx, sy, 0));
		while(!pq.isEmpty()){
			if(adj[sx][sy]<0)break;
			node no=pq.poll();
			int curx=no.x, cury=no.y;
			if(adj[curx][cury]>0){
				if(adj[curx][cury]==1&&dis[curx][cury-1]==-1&&adj[curx][cury-1]>=0){
					dis[curx][cury-1]=dis[curx][cury];
					pq.add(new node(curx, cury-1, dis[curx][cury-1]));
				}else if(adj[curx][cury]==2&&dis[curx][cury+1]==-1&&adj[curx][cury+1]>=0){
					dis[curx][cury+1]=dis[curx][cury];
					pq.add(new node(curx, cury+1, dis[curx][cury+1]));
				}else if(adj[curx][cury]==3&&dis[curx-1][cury]==-1&&adj[curx-1][cury]>=0){
					dis[curx-1][cury]=dis[curx][cury];
					pq.add(new node(curx-1, cury, dis[curx-1][cury]));
				}else if(adj[curx][cury]==4&&dis[curx+1][cury]==-1&&adj[curx+1][cury]>=0){
					dis[curx+1][cury]=dis[curx][cury];
					pq.add(new node(curx+1, cury, dis[curx+1][cury]));
				}
			}else{
				for(int i=0;i<4;i++){
					int mx=curx+mv[i][0], my=cury+mv[i][1];
					if(adj[mx][my]>=0&&dis[mx][my]==-1){
						dis[mx][my]=dis[curx][cury]+1;
						pq.add(new node(mx, my, dis[mx][my]));
						
					}
				}
			}
		}
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){
				if(open[i][j])System.out.println(dis[i][j]);
			}
		}
	}
}