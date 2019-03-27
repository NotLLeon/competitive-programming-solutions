import java.util.*;
import java.io.*;
public class checker {
	static int [][]bit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m=Integer.parseInt(st.nextToken()), n=Integer.parseInt(st.nextToken());
		bit=new int[m][n];
		while(true){
			st=new StringTokenizer(br.readLine());
			int cmd=Integer.parseInt(st.nextToken());
			if(cmd==0){
				break;
			}else if(cmd==1){
				int r=Integer.parseInt(st.nextToken()), c=Integer.parseInt(st.nextToken()), x=Integer.parseInt(st.nextToken());
				update(r,c,x);
			}else{
				int r1=Integer.parseInt(st.nextToken()),c1=Integer.parseInt(st.nextToken()),r2=Integer.parseInt(st.nextToken()),c2=Integer.parseInt(st.nextToken());
				System.out.println();
			}

		}

	}
	public static void update(int r,int c, int x){
		for(int r1=r, c1=c;r1>0&&c1<=bit.length;c1+=r1&-r1,r1-=r1&-r1){
			bit[r1-1][c1-1]+=x;
		}
	}
	public static int Query(int r, int c){
		int sum=0;
		for(int r1=r, c1=c;c1>0&&r1<=bit.length;c1-=r1&-r1,r1+=r1&-r1){
			sum+=bit[r1-1][c1-1];
		}
		return sum;
	}

}
