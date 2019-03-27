import java.util.Scanner;
public class p129ex3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		if(n==1){
			System.out.println(0);
			
		} else {
		int pow=1;
		for(int i=0;i>-1;i++){
			pow=pow*2;
			if(pow>=n){
				System.out.println(i+1);
				break;
			}
			}
		}
		}
	}


