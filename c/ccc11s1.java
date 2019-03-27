import java.util.*;
public class ccc11s1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int t=0;
		int s=0;
		for(int i=0;i<N+1;i++){
			String S=sc.nextLine();
			for(int j=0;j<S.length();j++){
				if(S.charAt(j)=='t'||S.charAt(j)=='T'){
					t++;
				}else if(S.charAt(j)=='s'||S.charAt(j)=='S'){
					s++;
				}
			}
		}
		if(t>s){
			System.out.println("English");
		}else {
			System.out.println("French");
		}
		
	}

}
