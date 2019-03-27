import java.util.*;
import java.io.*;
public class cco12p4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[]sz=new int[n];
		for(int i=0;i<n;i++)sz[i]=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int sy=Integer.parseInt(st.nextToken())-1, sx=Integer.parseInt(st.nextToken())-1;
		st=new StringTokenizer(br.readLine());
		int fy=Integer.parseInt(st.nextToken())-1, fx=Integer.parseInt(st.nextToken())-1;
		boolean[][]vis=new boolean[n][80];
		Queue<Integer>x=new LinkedList<Integer>(), y=new LinkedList<Integer>(), d=new LinkedList<Integer>();
		x.add(sx);
		y.add(sy);
		d.add(0);
		vis[sy][sx]=true;
		while(!x.isEmpty()){
			int cx=x.poll(), cy=y.poll(), cd=d.poll();
			if(cx==fx&&cy==fy){
				System.out.println(cd);
				break;
			}
			if(cx+1==sz[cy]){
				if(cy+1<n&&!vis[cy+1][0]){
					vis[cy+1][0]=true;
					x.add(0);
					y.add(cy+1);
					d.add(cd+1);
				}
			}else if(!vis[cy][cx+1]){
				vis[cy][cx+1]=true;
				x.add(cx+1);
				y.add(cy);
				d.add(cd+1);
			}

			if(cx-1<0){
				if(cy-1>=0&&!vis[cy-1][sz[cy-1]-1]){
					vis[cy-1][sz[cy-1]-1]=true;
					x.add(sz[cy-1]-1);
					y.add(cy-1);
					d.add(cd+1);
				}
			}else if(!vis[cy][cx-1]){
				vis[cy][cx-1]=true;
				x.add(cx-1);
				y.add(cy);
				d.add(cd+1);
			}

			if(cy+1<n&&!vis[cy+1][Math.min(sz[cy+1]-1, cx)]){
				vis[cy+1][Math.min(sz[cy+1]-1, cx)]=true;
				x.add(Math.min(sz[cy+1]-1, cx));
				y.add(cy+1);
				d.add(cd+1);
			}
			
			if(cy-1>=0&&!vis[cy-1][Math.min(sz[cy-1]-1, cx)]){
				vis[cy-1][Math.min(sz[cy-1]-1, cx)]=true;
				x.add(Math.min(sz[cy-1]-1, cx));
				y.add(cy-1);
				d.add(cd+1);
			}
			
		}
	}

}
