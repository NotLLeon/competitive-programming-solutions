import java.util.*;
import java.io.*;
public class waterloof2017c {

	public static void main(String[] args)throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()), k=Integer.parseInt(st.nextToken());
		int[]ar=new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)ar[i]=Integer.parseInt(st.nextToken());
		Arrays.sort(ar);
		
	}

}
