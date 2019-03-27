import java.util.*;
public class pacnw16a {
	static int[][]lcs;
	static String s,a;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		s=sc.nextLine(); a="abcdefghijklmnopqrstuvwxyz";
		lcs=new int[s.length()][26];
		for(int i=0;i<s.length();i++)Arrays.fill(lcs[i], -1);
		System.out.println(26-solve(s.length()-1,25));
	}
	static int solve(int i1, int i2){
		if(i1<0||i2<0)return 0;
		if(lcs[i1][i2]==-1){
			if(s.charAt(i1)==a.charAt(i2))lcs[i1][i2]=solve(i1-1,i2-1)+1;
			else lcs[i1][i2]=Math.max(solve(i1-1,i2),solve(i1,i2-1));
		}
		return lcs[i1][i2];
	}

}