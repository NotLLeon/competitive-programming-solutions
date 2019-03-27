import java.util.*;
public class ccc12j2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
	int a = sc.nextInt();
	int b = sc.nextInt();
	int c = sc.nextInt();
	int d = sc.nextInt();
	
	if (a<b && b<c && c<d){
		System.out.println("Fish Rising");
	}else if (a>b && b>c && c>d){
		System.out.println("Fish Diving");
	}else if (a==b && b==c && c==d){
		System.out.println("Fish At Constant Depth");
	} else {System.out.println("No Fish");}

	}

}