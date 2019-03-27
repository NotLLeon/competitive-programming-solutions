import java.util.*;
public class dmopc17c2p0 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int x1=sc.nextInt(), y1=sc.nextInt();
		int x2=sc.nextInt(), y2=sc.nextInt();
		int s1=sc.nextInt(), s2=sc.nextInt();
		int d=sc.nextInt();
		if(Math.sqrt(Math.pow(Math.abs(x1-s1), 2)+Math.pow(Math.abs(y1-s2), 2))<=d||Math.sqrt(Math.pow(Math.abs(x2-s1), 2)+Math.pow(Math.abs(y2-s2), 2))<=d){
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}
		

	}

}
