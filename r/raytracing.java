import java.util.*;
import java.io.*;
public class raytracing {
	static int[][]bit;
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		bit=new int[n+5][n+5];
		int[]cur=new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			cur[i]=Integer.parseInt(st.nextToken())+2;
			update(i+2,cur[i],1);
		}
		int q=Integer.parseInt(br.readLine());
		for(int i=0;i<q;i++){
			st=new StringTokenizer(br.readLine());
			if(Integer.parseInt(st.nextToken())==1){
				int x1=Integer.parseInt(st.nextToken())+2, x2=Integer.parseInt(st.nextToken())+2;
				int y1=Integer.parseInt(st.nextToken())+2, y2=Integer.parseInt(st.nextToken())+2;
				System.out.println(query(x2,y2)-query(x1-1,y2)-query(x2,y1-1)+query(x1-1,y1-1));
			}else{
				int x=Integer.parseInt(st.nextToken())+2, y=Integer.parseInt(st.nextToken())+2;
				update(x,cur[x-2],-1);
				update(x,y,1);
				cur[x-2]=y;
			}
		}
	}
	static void update(int x, int y, int val){
		for(;x<bit.length;x+=(x&-x)){
			for(int i=y;i<bit.length;i+=(i&-i)){
				bit[x][i]+=val;
			}
		}
	}
	static int query(int x, int y){
		int sum=0;
		for(;x>0;x-=(x&-x)){
			for(int i=y;i>0;i-=(i&-i)){
				sum+=bit[x][i];
			}
		}
		return sum;
	}
}
