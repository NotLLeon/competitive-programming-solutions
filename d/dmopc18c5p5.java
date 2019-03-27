import java.util.*;
import java.io.*;
public class dmopc18c5p5 {
	static int n;
	static long[][]ar;
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		ar=new long[n][2];
		StringTokenizer st;	
		for(int i=0;i<n;i++){
			st=new StringTokenizer(br.readLine());
			ar[i][0]=Long.parseLong(st.nextToken());
			ar[i][1]=Long.parseLong(st.nextToken());
		}
		for(int i=0;i<n;i++){
			long sum1=0,sum2=0, min;
			for(int j=n-1;j>i;j--)sum2+=Math.abs(ar[i][0]-ar[i][1]);
			min=sum2+Math.abs(ar[i][0]-ar[i][1]);
			int mi=i;
			for(int j=i;j<n-1;j++){
				sum2-=Math.abs(ar[j+1][0]-ar[j+1][1]);
				sum1+=Math.abs(ar[j+1][0]-ar[j][1]);
				if(sum2+sum1+Math.abs(ar[j][0]-ar[j+1][1])<min){
					min=sum2+sum1+Math.abs(ar[j][0]-ar[j+1][1]);
					mi=j;
				}
			}
			long temp=ar[i][0];
			for(int j=i;j<mi;j++)ar[j][0]=ar[j+1][0];
			ar[mi][0]=temp;
		}
		long ans=0;
		for(int i=0;i<n;i++)System.out.print(ar[i][0]+" ");
		for(int i=0;i<n;i++)ans+=Math.abs(ar[i][0]-ar[i][1]);
		System.out.println(ans);
	}
}
