import java.util.*;
public class p156ex13 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int count=0;
		int primes=0;
		int line=0;
		for(int i=2;i>-1;i++){
			for(int j=1;j<=i;j++){
				if (i%j==0){
					count++;
				}
			}
			if(count==2){
				System.out.print(i+" ");
				line++;
				primes++;
				if(line%10==0){
					System.out.println("");
				}
			}
			if(primes==N){
				break;
			}
			count=0;
		}
	
	}

}
