import java.util.*;
import java.io.*;
public class ccc03s4 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0){
			String s=br.readLine();
			String[]ss=new String[s.length()];
			for(int i=0;i<s.length();i++)ss[i]=s.substring(i);
			Arrays.sort(ss);
			int count=ss[0].length()+1;
			for(int i=1;i<ss.length;i++)count+=ss[i].length()-lcp(ss[i],ss[i-1]);
			System.out.println(count);
		}

	}
	static int lcp(String a, String b){
		int ans=Math.min(a.length(), b.length());
		for(int i=0;i<ans;i++)if(a.charAt(i)!=b.charAt(i))return i;
		return ans;
	}
}