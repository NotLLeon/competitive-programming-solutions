import java.util.*;
public class ccc12s4 {
	static int n;
	static class node{
		int [][]perm;
		int []i;
		int mv;
		node(int a, int [][]b, int[]c){
			mv=a;perm=b;i=c;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			n=sc.nextInt();
			if(n==0)break;
			int[][]c=new int[n][n];
			int []cind=new int[n], in={-1,1};
			for(int i=0;i<n;i++)c[i][cind[i]++]=sc.nextInt();
			Queue<node>q=new LinkedList<node>();
			q.add(new node(0,c,cind));
			int min=-1;
			TreeSet<String>vis=new TreeSet<String>();
			vis.add(id(c, cind));
			while(!q.isEmpty()){
				node cur=q.poll();
				boolean flg=false;
				for(int i=1;i<n;i++){
					if(cur.i[i-1]==0||cur.i[i]==0||cur.perm[i][cur.i[i]-1]<cur.perm[i-1][cur.i[i-1]-1]){
						flg=true;
						break;
					}
				}
				if(!flg){
					min=cur.mv;
					break;
				}
				for(int i=0;i<n;i++){
					if(cur.i[i]==0)continue;
					for(int j:in){
						if(i+j<n&&i+j>=0&&(cur.i[i+j]==0||cur.perm[i][cur.i[i]-1]<cur.perm[i+j][cur.i[i+j]-1])){
							cur.perm[i+j][cur.i[i+j]++]=cur.perm[i][cur.i[i]-1];
							cur.perm[i][--cur.i[i]]=0;
							System.out.println();
							String cid=id(cur.perm, cur.i);
							if(!vis.contains(cid)){
								System.out.println(cid);
								vis.add(cid);
								q.add(new node(cur.mv+1, cur.perm, cur.i));
							}
							cur.perm[i][cur.i[i]++]=cur.perm[i+j][cur.i[i+j]-1];
							cur.perm[i+j][--cur.i[i+j]]=0;
						}
					}
				}
			}
			System.out.println(min==-1?"IMPOSSIBLE":min);
		}
	}
	static String id(int[][]x, int[]ind){
		String ans="";
		for(int i=0;i<n;i++){
			for(int j=ind[i]-1;j>=0;j--){
				ans+=x[i][j];
			}
			ans+=" ";
		}
		return ans;
	}
}