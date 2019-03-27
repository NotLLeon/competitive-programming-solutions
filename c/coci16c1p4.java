import java.util.*;
import java.io.*;
public class coci16c1p4 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		LinkedList<Integer>[]adj=new LinkedList[n];
		for(int i=0;i<n;i++)adj[i]=new LinkedList<Integer>();
		StringTokenizer st;
		for(int i=0;i<n-1;i++){
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken()), b=Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}
		long []m=new long[n];
		for(int i=0;i<n;i++)m[i]=Integer.parseInt(br.readLine());
		

	}

}
