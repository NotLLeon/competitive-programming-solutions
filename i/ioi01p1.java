import java.util.*;
import java.io.*;
public class ioi01p1 {
	static int[][]a2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int o = Integer.parseInt(st.nextToken()), s=Integer.parseInt(st.nextToken());
		a2=new int[s][32769];
		while(true){
			st =new StringTokenizer(br.readLine());
			int n= Integer.parseInt(st.nextToken());
			if(n==1){
				int x=Integer.parseInt(st.nextToken()), y=Integer.parseInt(st.nextToken()), a = Integer.parseInt(st.nextToken());
				update(x,y,a);
				System.out.println();
				for(int i=0;i<a2.length;i++){
					System.out.println();
					for(int j=0;j<20;j++){
						System.out.print(a2[i][j]);
					}
				}
				System.out.println();
			}else if(n==2){
				int l=Integer.parseInt(st.nextToken()), b=Integer.parseInt(st.nextToken()), r=Integer.parseInt(st.nextToken()), t=Integer.parseInt(st.nextToken());
				System.out.println(Query(l+1,b+1,r,t));
			}else if(n==3){
				break;
			}
		}
	}
	public static void update(int x, int y, int a){
		for(; x<a2.length;x+=(x&-x)){
			for(int y1=y; y1<a2[x].length;y1+=(y1&-y1)){
				a2[x][y1]+=a;
			}
		}
	}
	public static int Query(int l, int b, int r, int t){
		int sum=0;
		for(; r>=l; r-=(r&-r)){
			for(int t1=t; t>=b;t-=(t&-t)){
				sum+=a2[r][t];
			}
		}
		return sum;
	}
}