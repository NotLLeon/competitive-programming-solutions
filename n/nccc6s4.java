import java.util.*;
import java.io.*;
public class nccc6s4 {
	static int a,b,c,d,q;
	static long[]pc;
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a=Integer.parseInt(st.nextToken());b=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());d=Integer.parseInt(st.nextToken());
		q=Integer.parseInt(st.nextToken());
		pc=new long[10000000];
		pc[0]=1;
		for(int i=1;i<pc.length;i++){
			pc[i]=((i/a-b)<0?1:pc[i/a-b])+((i/c-d)<0?1:pc[i/c-d]);
		}
		for(int i=0;i<q;i++){
			int nq=Integer.parseInt(br.readLine());
			System.out.println(solve(nq));
		}
	}
	static long solve(int x){
		if(x<0)return 1;
		if(x<10000000)return pc[x];
		else return solve(x/a-b)+solve(x/c-d);
	}

}