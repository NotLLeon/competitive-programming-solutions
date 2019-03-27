import java.util.*;
import java.io.*;
public class dmopc18c5p2 {
	static double[][]ar;
	static int n,m;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken()); m=Integer.parseInt(st.nextToken());
		ar=new double[n][m];
		double avg=0;
		for(int i=0;i<n;i++){
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++){
				ar[i][j]=Double.parseDouble(st.nextToken());
				avg+=ar[i][j];
			}
		}
		if(Math.abs(avg-0.48*n*m)<0.00001){
			System.out.println("correctly exposed");
			return;
		}else if(avg<0.48*n*m)System.out.println("underexposed");
		else System.out.println("overexposed");
		double lo=0.0, hi=1000.0, mid=0, cur=0, tar=0.48*n*m;
		while(true){
			mid=(lo+hi)/2;
			cur=check(mid);
			if(Math.abs(cur-tar)<0.00001)break;
			else if(cur<tar)lo=mid;
			else hi=mid;
		}
		System.out.printf("%.5f\n",mid);
	} 
	static double check(double c){
		double sum=0;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				sum+=Math.min(1.0, ar[i][j]*c);
			}
		}
		return sum;
	}

}