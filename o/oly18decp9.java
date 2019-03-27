import java.util.*;
import java.io.*;
public class oly18decp9 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine()), ans=Integer.MAX_VALUE;
		int[]nxt=new int[n];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)nxt[i]=Integer.parseInt(st.nextToken())-1;
		int[]vis=new int[n];
		int t=0, ct=0, cur=0;
		Arrays.fill(vis, -1);

		System.out.println(ans);
	}
}
