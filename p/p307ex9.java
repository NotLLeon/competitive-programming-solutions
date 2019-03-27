import java.util.*;
public class p307ex9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T=sc.nextInt();
		for(int i=0;i<T;i++){
			int n=sc.nextInt();
			if(n%4==0&&n%100!=0){
				System.out.println(1);
			} else if(n%400==0||n==0){
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}

	}

}
