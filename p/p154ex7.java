import java.util.*;
public class p154ex7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String M=sc.next();
		String N= sc.next();
		
		int MM = Integer.parseInt(M);
		int NN = Integer.parseInt(N);
		
		
		for(int i=MM;i<NN;i++){
			String I = Integer.toString(i);
			int M1= Integer.parseInt(I.substring(0,1));
			int M2= Integer.parseInt(I.substring(1,2));
			int M3= Integer.parseInt(I.substring(2,3));
			int t=(M1*M1*M1)+(M2*M2*M2)+(M3*M3*M3);
			if(i==t){
				System.out.println(i);
			}
		}

	}

}
