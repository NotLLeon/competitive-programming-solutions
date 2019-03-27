import java.util.*;
public class pacnw16c {
	static int n,k,r,ans, cnt;
	static boolean[]arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt(); k=sc.nextInt(); r=sc.nextInt(); cnt=0;
		int right=r-1, left=0;
		arr=new boolean[n];
		while(k-->0)arr[sc.nextInt()-1]=true;
		for(int i=0;i<r;i++)if(arr[i])cnt++;
		placeCam(2-cnt,r-1);
		while(right+1<n){
			right++;
			if(arr[right])cnt++;
			if(arr[left])cnt--;
			left++;
			placeCam(2-cnt,right);
		}
		System.out.println(ans);
	}
	static void placeCam(int num,int ind){
		while(num-->0){
			ans++;
			for(int i=ind;i>=0;i--){
				if(!arr[i]){
					arr[i]=true;
					cnt++;
					break;
				}
			}
		}
	}

}
