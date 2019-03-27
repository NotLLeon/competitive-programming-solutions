import java.util.*;
public class ccc12j3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String [] l1={"*","x","*"};
		String [] l2={" ","x","x"};
		String [] l3={"*"," ","*"};
		int n=sc.nextInt();
		for(int i=0;i<n;i++){
			for(int j=0;j<3;j++){
				for(int l=0;l<n;l++){
				System.out.print(l1[j]);
				}
			}
			System.out.println();
		}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<3;j++){
				for(int l=0;l<n;l++){
				System.out.print(l2[j]);
				}
			}
			System.out.println();
		}

		for(int i=0;i<n;i++){
			for(int j=0;j<3;j++){
				for(int l=0;l<n;l++){
				System.out.print(l3[j]);
				}
			}
			System.out.println();
		}

	}

}
