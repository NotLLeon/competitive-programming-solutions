import java.util.*;
import java.io.*;
public class coci14c3p2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()), m=Integer.parseInt(st.nextToken()), p=Integer.parseInt(st.nextToken())-1;
		int[]c=new int[m];
		Arrays.fill(c, -1);
		boolean[]vis=new boolean[m];
		for(int i=0;i<n;i++){
			st=new StringTokenizer(br.readLine());
			int f=Integer.parseInt(st.nextToken())-1, h=Integer.parseInt(st.nextToken())-1;
			if(c[h]==-1)c[h]=f;
		}
		vis[p]=true;
		int cnt=0;
		while(c[p]!=-1){
			int nxt=c[p];
			if(vis[nxt]){
				System.out.println(-1);
				return;
			}
			vis[nxt]=true;
			p=nxt;
			cnt++;
		}
		System.out.println(cnt);
		
	}

}
