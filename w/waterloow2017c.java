import java.util.*;
public class waterloow2017c {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(), k=sc.nextInt();
		int[]arr=new int[n+1];
		for(int i=1;i<=n;i++){
			if(i-k>0)arr[i]=arr[i-k]-1;
			else arr[i]=arr[i-1]+1;
		}
	}
}
