/*
ID: NotLeon
LANG: JAVA
TASK: blist
*/
import java.util.*;
import java.io.*;
public class blist {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("blist.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));
		int n=Integer.parseInt(br.readLine());
		int[]f=new int[1001];
		for(int i=0;i<n;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken()), b=Integer.parseInt(st.nextToken()), c=Integer.parseInt(st.nextToken());
			for(int j=a;j<=b;j++)f[j]+=c;
		}
		int max=0;
		for(int i=0;i<1001;i++)max=Math.max(max, f[i]);
		out.println(max);
		out.close();
	}

}