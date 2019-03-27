import java.util.*;
import java.io.*;
public class dmopc18c4p1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k=Integer.parseInt(br.readLine());
		double mx=Double.parseDouble(br.readLine()), mean=mx;
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		for(int i=0;i<n;i++)mean+=Double.parseDouble(st.nextToken());
		for(int i=1;i<k;i++){
			st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			for(int j=0;j<n;j++){
				mean+=Double.parseDouble(st.nextToken());
			}
			mean+=mx;
		}
		System.out.println(mean/k);

	}

}
