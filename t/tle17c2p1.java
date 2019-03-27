import java.util.*;
import java.io.*;
public class tle17c2p1 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine(), ans="";
		int cnt=0;
		for(int i=2;i<s.length();i++){
			char c=s.charAt(i);
			if(c=='a'){
				cnt++;
				System.out.print("(car ");
			}else if(c=='d'){
				System.out.print("(cdr ");
				cnt++;
			}else if(c!='r'&&c!=' '){
				System.out.print(s.charAt(i));
			}
		}
		for(int i=1;i<cnt;i++){
			System.out.print(")");
		}

	}

}
