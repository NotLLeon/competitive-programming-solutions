import java.util.*;
public class ccc05j5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			String s=sc.nextLine();
			if(s.equals("X"))break;
			System.out.println(isMonkey(s)?"YES":"NO");
		}

	}
	static boolean isMonkey(String s){
		if(s.equals("A"))return true;
		if(s.contains("ANA")||s.contains("BAS")){
			s=s.replace("ANA", "A");
			s=s.replace("BAS", "A");
			return isMonkey(s);
		}
		return false;
	}

}
