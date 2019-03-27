import java.util.*;
public class p118ex5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		double[] A = new double[N];
		double[] B = new double[N];
		for(int i=0;i<N;i++){
			A[i] = sc.nextDouble();
			B[i]=A[i];
		}
		
		Arrays.sort(B);
		double max=B[N-1];
		for(int j=0;j<N;j++){
			if(A[j]==0.0 && A[j]!=max){
				System.out.println("0.00");
			} else if(A[j]!=max){
				System.out.printf("%.2f", A[j]);
				System.out.println("");
			}
		}
		if(max==0.0){
			System.out.println("0.00");
		} else {
			System.out.printf("%.2f", max);
		}
	}

}
