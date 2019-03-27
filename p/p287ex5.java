import java.util.*;
public class p287ex5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 
		int T=sc.nextInt();
		for(int i=0;i<T;i++){
			String a=sc.next();
			a=a.replaceAll("-", "");
				System.out.println(a.length());
			}
		}

	}


