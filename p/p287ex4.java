import java.util.*;
public class p287ex4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T=sc.nextInt();
		String r= sc.nextLine();
		for(int i=0;i<T;i++){
			boolean s=false;
			String a =sc.nextLine();
			if(a.contains(" ")){
			for(int j=0;j<a.length();j++){
				if(a.charAt(j)==' '){
					if(s==false){
					System.out.println(j+1);
					s=true;
					}
				}
				}
				} else {
					System.out.println("0");
				}

		}

	}

}
