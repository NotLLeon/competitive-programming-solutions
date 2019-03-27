import java.util.*;
import java.io.*;
public class gfssoc1j5 {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()), m=Integer.parseInt(st.nextToken()), t=Integer.parseInt(st.nextToken());
		LinkedList<Integer>[] l = new LinkedList[n+1];
		for(int i=0;i<n+1;i++){
			l[i]=new LinkedList<Integer>();
		}
		for(int i=0;i<m;i++){
			st=new StringTokenizer(br.readLine());
			l[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}
		int q=Integer.parseInt(br.readLine());
		for(int j=0;j<q;j++){
			st=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());int to=Integer.parseInt(st.nextToken());
			Queue<Integer>Q=new LinkedList<Integer>();
			Q.add(from);
			int []dis=new int[n+1];
			boolean[]vis=new boolean[n+1];
			vis[from]=true;
			while(!Q.isEmpty()){
				int cur=Q.poll();
				for(int i:l[cur]){
					if(!vis[i]){
						vis[i]=true;Q.add(i);dis[i]=dis[cur]+1;
					}
				}
				if(vis[to]){
					System.out.println(dis[to]*t);
					break;
				}
			}
			if(!vis[to]){
				System.out.println("Not enough hallways!");
			}
		}
	}
}