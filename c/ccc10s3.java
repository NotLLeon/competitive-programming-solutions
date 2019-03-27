import java.util.*;
public class ccc10s3 {
	static int h,k;
	static int[]ar;
	static int mx=1000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		h=sc.nextInt();
		ar=new int[h];
		for(int i=0;i<h;i++)ar[i]=sc.nextInt();
		Arrays.sort(ar);
		k=sc.nextInt();
		System.out.println(bSearch(0,mx));
	}
	static int bSearch(int lo, int hi){
		int mid=(lo+hi)/2;
		if(hi<=lo)return mid;
		if(check(mid))hi=mid;
		else lo=mid+1;
		return bSearch(lo,hi);
	}
	static boolean check(int max){
		int c=-1, cnt=0;
		boolean[]vis=new boolean[h];
		for(int i=0;i<h;i++){
			if(ar[i]>c){
				vis[i]=true;
				cnt++;
				c=ar[i]+2*max;
			}
		}
		if(c-mx >= 0){
			for (int i = 0; i < h; i++){
				if (ar[i]>c-mx)break;
				else if (vis[i])cnt--;
			}
		}
		return cnt<=k;
	}
}
