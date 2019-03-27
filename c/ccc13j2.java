import java.util.*;
public class ccc13j2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int count=0;
		char[] letters={'I', 'O', 'S', 'H','Z', 'X', 'N'};
		for(int i=0;i<s.length();i++){
			for(int j=0;j<letters.length;j++){
				if(s.charAt(i)==letters[j]){
					count++;
				}
			}
		}
		if(count==s.length()){
			System.out.println("YES");
		} else{
			System.out.println("NO");
		}

	}

}
