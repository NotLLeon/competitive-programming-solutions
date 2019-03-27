import java.util.*;
public class bts17p1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s=sc.nextLine(), ans=s;
		for(int i=s.length()-1;i>0;i--){
			if(s.charAt(i)>=65&&s.charAt(i)<=90&& s.charAt(i-1)==' '){
				String s1=ans.substring(0, i-1), s2=ans.substring(i-1, ans.length());
				ans=s1+"."+s2;
			}
		}
		System.out.println(ans+".");
	}
}
