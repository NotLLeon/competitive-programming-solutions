import  java.util.*;
public class ccc12j4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int K=sc.nextInt();
		String s = sc.next();
		char [] S = new char [s.length()];
		for(int i=0;i<s.length();i++){
			S[i]=s.charAt(i);
			int sn=3*(i+1)+K;
			int f= (int)(S[i]-sn);
			if(f<65){
				int g=64-f;
				System.out.print((char)(90-g));
			} else {
				System.out.print((char)(f));
			}
			
		}
		

	}

}
