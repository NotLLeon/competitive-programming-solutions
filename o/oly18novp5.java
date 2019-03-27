import java.util.*;
import java.io.*;
public class oly18novp5 {

	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()), k=Integer.parseInt(st.nextToken());
		long[]dp=new long[n+1];
		long[]ar=new long[n];
		for(int i=0;i<n;i++)ar[i]=Integer.parseInt(br.readLine());
		long max=0;
		System.out.println(max);

	}

}