import java.util.*;
public class dmopc17c2p6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int [][]a=new int[n][2];
		int [] ans=new int[n], best=new int[n];
		for(int i=0;i<n;i++)a[i][0]=sc.nextInt();
		for(int i=0;i<n;i++)a[i][1]=sc.nextInt();
		int cnt=0, min=0;
		for(int i=0, cur=0;i<n;i++){
			if(a[i][0]<a[i][1]){
				best[i]=1;
				cur=1;
				cnt++;
			}
			min=Math.min(min, a[i][cur]);
		}
		ans[cnt]=min;
		
	}
}
