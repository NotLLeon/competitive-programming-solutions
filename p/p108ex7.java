import java.util.*;
public class p108ex7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int cost=0;
		for(int i=0;i<t;i++){
			int n = sc.nextInt();
			if(n>=0 && n<=30){
				cost=38;
			} else if(n>30 && n<=50){
				cost=55;
			} else if(n>50 && n<=100){
				cost=73;
			} else if(n>100){
				cost=97;
				for(int j=150;j<n;j=j+50){
					if(n>j){
						cost=cost+24;
					} 
				}
		
			}
			System.out.println(cost);
		}
		

	}

}
