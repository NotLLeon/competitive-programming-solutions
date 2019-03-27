import java.util.*;
import java.io.*;
public class ichb2017p3 {
	static long[][]bit;
	static long[]cur;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()), q=Integer.parseInt(st.nextToken());
		cur=new long[n];
		bit=new long[32][n+5];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			cur[i]=Long.parseLong(st.nextToken());
			for(int j=0;j<32;j++)if((cur[i]&(1<<j))!=0)update(j,i+2,1);
		}
		while(q-->0){
			st=new StringTokenizer(br.readLine());
			String cmd=st.nextToken();
			if(cmd.equals("U")){
				int x=Integer.parseInt(st.nextToken());
				long v=Long.parseLong(st.nextToken());
				for(int i=0;i<32;i++)if((cur[x-1]&(1<<i))!=0)update(i,x+1,-1);
				for(int i=0;i<32;i++)if((v&(1<<i))!=0)update(i,x+1,1);
				cur[x-1]=v;
			}else{
				int x=Integer.parseInt(st.nextToken()), y=Integer.parseInt(st.nextToken());
				long v=Long.parseLong(st.nextToken());
				int ans=0;
				for(int i=0;i<32;i++){
					if(query(i,y+1)-query(i,x)==y-x+1)ans+=1<<i;
				}
				System.out.println(ans&v);
			}
		}
	}
	static void update(int x, int y, int val){
		for(;y<bit[0].length;y+=(y&-y))bit[x][y]+=val;
	}
	static int query(int x, int y){
		int sum=0;
		for(;y>0;y-=(y&-y))sum+=bit[x][y];
		return sum;
	}
}
