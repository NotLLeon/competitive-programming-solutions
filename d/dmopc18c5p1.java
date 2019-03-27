import java.util.*;
public class dmopc18c5p1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(), m=sc.nextInt(), k=sc.nextInt(),cnt=0;
		for(int i=0;i<k;i++){
			if(((n&(1<<i))!=(m&(1<<i))))cnt++;
		}
		System.out.println(cnt+" "+(k-cnt));

	}

}
