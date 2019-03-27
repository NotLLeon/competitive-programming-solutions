import java.util.*;
public class wc171i1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a=0, b=0;
		for(int i=0;i<7;i++){
			int x=sc.nextInt(), y=sc.nextInt();
			if(x>y)a++;
			else b++;
			if(a==4||b==4)break;
		}
		System.out.println(a+" "+b);
	}

}
