import java.util.*;
public class year2018p7 {
	static ArrayList<Integer>[]adj;
	static int n;
	static int size[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		adj=new ArrayList[n];
		for(int i=0;i<n;i++)adj[i]=new ArrayList<Integer>();
		for(int i=0;i<n-1;i++){
			int x=sc.nextInt()-1;
			adj[x].add(i+1);
		}
		size=new int[n];
		String temp=sc.nextLine();
		for(int i=0;i<n;i++){
			String s=sc.nextLine();
			size[i]=s.length();
		}
		int f=-1, s=-1, c=-1;
		for(int i:adj[0]){
			int []d=DFS(i);
			c=Math.max(c, d[1]);
			if(d[0]>=f){
				s=f;
				f=d[0];
			}else if(d[0]>s){
				s=d[0];
			}
		}
		if(Math.max(s, c)<=0)System.out.println(-1);
		else System.out.println(Math.max(s, c));

	}
	static int[] DFS(int cur){
		if(adj[cur].isEmpty())return new int[]{size[cur],0};
		int max1=-1, max2=-1, maxc=-1;
		for(int i:adj[cur]){
			int [] nxt=DFS(i);
			if(nxt[0]>=max1){
				max2=max1;
				max1=nxt[0];
			}else if(nxt[0]>max2){
				max2=nxt[0];
			}
			maxc=Math.max(maxc, nxt[1]);
		}
		System.out.println(cur+" "+max1+" "+Math.max(maxc,max2));
		return new int[]{max1, Math.max(maxc,max2)};
	}
}
