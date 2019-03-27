import java.util.*;
import java.io.*;
public class ccc04s5 {
//idk what im doing
//try implementing a solution where each path carries its own weight and only that
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [][]way={{-1,0},{1,0},{0,1}};
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r=Integer.parseInt(st.nextToken()), c=Integer.parseInt(st.nextToken());
			if(r==0||c==0)break;
			int[][]adj=new int [r][c];
			int [][]val=new int[r][c];
			boolean[][]vis=new boolean[r][c];
			for(int i=0;i<r;i++){
				String s=br.readLine();
				for(int j=0;j<c;j++){
					String s1=s.substring(j, j+1);
					if(s1.equals("*")){
						adj[i][j]=-1;
					}else if(!s1.equals(".")){
						adj[i][j]=Integer.parseInt(s1);
						val[i][j]=Integer.parseInt(s1);
					}
				}
			}
			Queue<Integer>q=new LinkedList<Integer>();
			q.add(r-1);q.add(0);
			vis[r-1][0]=true;
			while(!q.isEmpty()){
				for(int i=0;i<r;i++)System.out.println(Arrays.toString(val[i]));
				System.out.println();
				int curr=q.poll();int curc=q.poll();
				for(int i=0;i<3;i++){
					int r1=curr+way[i][0], c1=curc+way[i][1];
					if(r1>-1&&r1<r&&c1>-1&&c1<c){
						if((!vis[r1][c1]&&adj[r1][c1]!=-1)){
						}
					}
				}
			}
			System.out.println(val[r-1][c-1]);
		}
	}
}
