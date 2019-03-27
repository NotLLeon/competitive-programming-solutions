import java.util.Scanner;
public class ccc07j3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt();
		int total = 1;
		for (int i =0; i<n; i++){
			int  a= sc.nextInt();
			
			switch (a){
			case 1: {
				int b = 100;
			}
			break;
			case 2: {
				int b = 500;
			}
			break;
			case 3: {
				int b = 1000;
			}
			break;
			case 4: {
				int b = 5000;
			}
			break;
			case 5: {
				int b = 10000;
			}
			break;
			case 6: {
				int b = 25000;
			}
			break;
			case 7: {
				int b = 50000;
			}
			break;
			case 8: {
				int b = 100000;
			}
			break;
			case 9: {
				int b = 500000;
			}
			break;
			case 10: {
				int b = 1000000;
			}
			break;
			
			}
			total=total*a;
		}
		int b = sc.nextInt();
		if (total/n>b){
			System.out.println("Deal");
		} else {
			System.out.println("No Deal");
		}

	}

}
