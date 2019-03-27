import java.util.*;
public class globexcup18s1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		boolean[]v=new boolean[n+1];
		for(int i=0;i<n;i++)v[sc.nextInt()]=true;
		int cnt=0;
		for(int i=1;i<n+1;i++){
			if(!v[i])cnt++;
		}
		System.out.println(cnt);
		

	}

}
