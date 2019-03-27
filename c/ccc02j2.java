import java.util.*;
public class ccc02j2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		while(true){
			String s= sc.nextLine().trim();
			if(s.equals("quit!"))break;
			if(s.length()>4){
					if(s.substring(s.length()-2,s.length()).equals("or")){
						if(s.charAt(s.length()-3)!='a'&&s.charAt(s.length()-3)!='e'&&s.charAt(s.length()-3)!='i'&&s.charAt(s.length()-3)!='o'&&s.charAt(s.length()-3)!='u'&&s.charAt(s.length()-3)!='y'){
							s=s.replace("or", "our");
						}
					}
				}
			System.out.println(s);
		}
		}
	}

