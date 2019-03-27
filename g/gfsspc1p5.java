import java.util.*;
public class gfsspc1p5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(), t=sc.nextInt(), cn=0;
		int[]ar=new int[n+1];
		ar[0]=0;
		for(int i=0;i<n;i++)ar[i+1]=sc.nextInt();
		Arrays.sort(ar);
		for(int i=0;i<n+1;i++)if(ar[i]<0)cn++;
		int ans=Integer.MAX_VALUE;
		for(int i=0;i<=t;i++){
			if(cn+t-i<=n&&cn-i>-1){
				int l=-ar[cn-i], r=ar[cn+t-i];
				ans=Math.min(ans,r+l+Math.min(l, r));
			}
		}
		System.out.println(ans);
	}

}
