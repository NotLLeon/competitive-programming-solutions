import java.util.*;
public class ccc09s2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r=sc.nextInt(), l=sc.nextInt();
		int[]ar=new int[r];
		for(int i=0;i<r;i++)for(int j=0;j<l;j++)ar[i]+=sc.nextInt()*(1<<j);
		int cnt=1, cur=ar[r-1], nxt;
		boolean[]vis=new boolean[1<<8];
		vis[cur]=true;
		for(int i=r-2;i>=0;i--){
			nxt=cur^(ar[i]);
			if(!vis[nxt]){
				cnt++;
				vis[nxt]=true;
			}
			cur=nxt;
		}
		System.out.println(cnt);
		
	}

}
