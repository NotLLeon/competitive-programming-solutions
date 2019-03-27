import java.util.Scanner;
public class p129ex5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String c1=sc.nextLine();
		String s=sc.nextLine();
		char c=c1.charAt(0);
		String cc1=c1.toUpperCase();
		char cc=cc1.charAt(0);
		
		int count=0;
		for(int i=0; i<s.length();i++){
			if(s.charAt(i)==c || s.charAt(i)==cc){
				count++;
			}
			}
		System.out.println(s);
		System.out.println(count);
		}
	}


