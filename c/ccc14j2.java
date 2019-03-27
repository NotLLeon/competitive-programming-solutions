import java.util.*;
public class ccc14j2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String s = sc.next();
		
		int counta=0;
		int countb=0;
		for(int i=0;i<N;i++){
			if(s.charAt(i)=='A'){
				counta++;
			} else if (s.charAt(i)=='B'){
				countb++;
			}
		}
		if(counta>countb){
			System.out.println("A");
		} else if (counta<countb){
			System.out.println("B");
		} else {
			System.out.println("Tie");
		}
	}

}
