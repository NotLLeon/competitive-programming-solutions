import java.util.*;
import java.io.*;
public class bts17p5 {
	static class query implements Comparable<query>{
		int ind, x, ch;
		query(int a, int b, int c){
			ind=a;x=b;ch=c;
		}
		public int compareTo(query e) {
			return this.ind-e.ind;
		}
	}
	public static void main(String[] args)throws IOException {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(), m=sc.nextInt();
		query []s=new query[m];
		String temp=sc.nextLine();
		for(int i=0;i<m;i++){
			int c=sc.next().charAt(0),b=sc.nextInt(), a=sc.nextInt();
			s[i]=new query(a,b,c);
		}
		Arrays.sort(s);
		int[]cnt=new int[200],vis=new int[26];
		Arrays.fill(vis, -1);
		int ind=0;
		String ans="";
		for(int i=0;i<m;i++){
			if(ind+(s[i].x-cnt[s[i].ch])<=s[i].ind){
				int t=0;
				for(int j=0;j<s[i].x-cnt[s[i].ch];j++){
					ans+=(char)s[i].ch;
					ind++;
					t++;
				}
				vis[s[i].ch-97]=s[i].ind;
				cnt[s[i].ch]+=t;
			}else{
				System.out.println(-1);
				return;
			}
		}
		if(ans.length()<n){
			for(int i=0;i<26;i++){
				if(vis[i]==-1||vis[i]<=ind){
					while(ans.length()<n)ans+=(char)(i+97);
					System.out.println(ans);
					return;
				}
			}
			System.out.println(-1);
		}else System.out.println(ans);

	}

}