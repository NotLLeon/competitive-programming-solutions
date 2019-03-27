import java.util.*;
public class lkp18c2p3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(), m=sc.nextInt();
		long[][]c=new long[n][2];
		for(int i=0;i<n;i++){
			c[i][0]=sc.nextLong();
			c[i][1]=sc.nextLong();
		}
		int[]ans=new int[m];
		for(int i=0;i<m;i++){
			int cnt=0;
			long x1=sc.nextInt(), y1=sc.nextInt();
			long x2=sc.nextInt(), y2=sc.nextInt();
			long x3=sc.nextInt(), y3=sc.nextInt();
			for(int j=0;j<n;j++){
				long sum=getArea(c[j][0],c[j][1],x2,y2,x3,y3)
						+getArea(x1,y1,c[j][0],c[j][1],x3,y3)
						+getArea(x1,y1,x2,y2,c[j][0],c[j][1]);
				if(sum==getArea(x1,y1,x2,y2,x3,y3))cnt++;
			}
			ans[i]=cnt;
		}
		for(int i=0;i<m;i++)System.out.println(ans[i]);
	}
	static long getArea(long x1, long y1, long x2, long y2, long x3, long y3){
		return Math.abs(x1*y2 + x2*y3 + x3*y1 - x1*y3 - x2*y1 - x3*y2);
	}
}
