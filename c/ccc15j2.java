import java.util.*;
public class ccc15j2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		String a =sc.nextLine();
		String h=a.replace(":-)", "");

		String s=a.replace(":-(", "");

		int h1=h.length();

		int s1=s.length();

		if(h1>s1){
			System.out.println("sad");
		} else if (h1<s1) {
			System.out.println("happy");
		} else if(h1==a.length() && s1==a.length()){
			System.out.println("none");
		} else {
			System.out.println("unsure");
		}

	}

}
