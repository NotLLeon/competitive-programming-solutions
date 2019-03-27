import java.util.*;
public class wc171i2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		if(s.length()==0){
			System.out.println("N");
			return;
		}
		String our="our";
		int ind=0;
		for(int i=0;i<s.length()&&ind<=2;i++){
			if(s.charAt(i)==our.charAt(ind)){
				ind++;
			}
		}
		if(ind==3)System.out.println("Y");
		else System.out.println("N");

	}

}
