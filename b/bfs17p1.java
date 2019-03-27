import java.util.*;
public class bfs17p1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(), cnt=0;
		for(int i=0;i<n;i++){
			String s= sc.next().trim();
			if(s.length()<=10)cnt++;
		}
		System.out.println(cnt);

	}

}
