import java.util.*;
import java.io.*;
public class dmopc17c2p2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s=sc.nextLine();
		Stack<Integer>st=new Stack<Integer>();
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='('){
				st.push(1);
			}else{
				if(st.isEmpty()||st.peek()!=1)st.push(0);
				else if(!st.isEmpty())st.pop();
			}
		}
		if(st.size()>2)System.out.println("NO");
		else System.out.println("YES");
	}
}

