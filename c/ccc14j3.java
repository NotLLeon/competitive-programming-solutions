import java.util.Scanner;
public class ccc14j3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
	int A = 100;
	int D = 100;
	
	int n = sc.nextInt();
	
	for(int i =0; i<n; i++){
		int a=sc.nextInt();
		int d=sc.nextInt();
	if(a<d){
		A=A-d;
	} else if (a>d){
		D=D-a;
	}
	}
System.out.println(A);
System.out.println(D);
	}

}
