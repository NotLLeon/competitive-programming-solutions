import java.util.*;
public class p184ex8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int A=0;
		int B=0;
		int C=0;
		int D=0;
		int E=0;
		int F=0;
		int S=0;
		for(int i=0;i<N;i++){
			String a = sc.next();
			if(a.equals("A")){
				A++;
			}else if(a.equals("B")){
				B++;
			}else if(a.equals("C")){
				C++;
			}else if(a.equals("D")){
				D++;
			}else if(a.equals("E")){
				E++;
			}else if(a.equals("F")){
				F++;
			}else{
				S++;
			}
		}
		System.out.println(A);
		System.out.println(B);
		System.out.println(C);
		System.out.println(D);
		System.out.println(E);
		System.out.println(F);
		System.out.println(S);

	}

}
