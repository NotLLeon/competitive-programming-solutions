import java.util.*;
public class p307ex7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T=sc.nextInt();
		for(int i=0;i<T;i++){
			int n=sc.nextInt();
			if(n<=100&&n>=80){
				System.out.println("A");
			} else if(n<=79&&n>=70){
				System.out.println("B");
			} else if(n<=69&&n>=60){
				System.out.println("C");
			} else if(n<=59&&n>=50){
				System.out.println("D");
			} else if(n<=49&&n>=0){
				System.out.println("F");
			} else {
				System.out.println("X");
			}
		}
	}

}
