import java.util.*;
import java.io.*;
public class globexcup18s0 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int []x=new int[n], y=new int[n];
		for(int i=0;i<n;i++){
			StringTokenizer st= new StringTokenizer(br.readLine());
			x[i]=Integer.parseInt(st.nextToken());
			y[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(x);
		Arrays.sort(y);
		long mx=x[n/2], my=y[n/2];
		long tot=0;
		for(int i=0;i<n;i++)tot+=Math.abs(mx-x[i])+Math.abs(my-y[i]);
		System.out.println(tot);

	}

}