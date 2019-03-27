import java.util.*;
import java.io.*;
public class dmopc18c4p6 {
	// partial
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()), m=Integer.parseInt(st.nextToken()), tot=0;
		int[]l=new int[2];
		st=new StringTokenizer(br.readLine());
		LinkedList<Integer>t=new LinkedList<Integer>(), o=new LinkedList<Integer>();
		for(int i=0;i<m;i++){
			int in=Integer.parseInt(st.nextToken());
			l[in-1]++;
			if(in==2)t.add(i+1);
			else o.add(i+1);
			tot+=in;
		}
		if(tot!=3*n){
			System.out.println("no");
			return;
		}
		System.out.println("yes");
		int[][]vis=new int[n][3];
		for(int i=n-1;i>=0;i--){
			if(l[1]!=0){
				int curs=t.poll();
				vis[i][0]=curs;
				vis[i][1]=curs;
				l[1]--;
			}else break;
		}
		int ind=0;
		while(l[1]!=0){
			int curs=t.poll();
			vis[ind][2]=curs;
			vis[ind+1][2]=curs;
			l[1]--;
			ind+=2;
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<3;j++){
				if(vis[i][j]==0){
					vis[i][j]=o.poll();
				}
			}
		}
		for(int i=0;i<3;i++){
			for(int j=0;j<n;j++){
				System.out.print(vis[j][i]+" ");
			}
			System.out.println();
		}
	}

}
