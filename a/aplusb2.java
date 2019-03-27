import java.util.*;
import java.io.*;
public class aplusb2 {
	//forgot about negatives oops
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a=st.nextToken(), b=st.nextToken();
			int size=Math.max(a.length(), b.length());
			int[]n1=new int[size], n2=new int[size], ans=new int[size+1];
			for(int j=0;j<a.length()-1;j++)n1[j]=a.charAt(a.length()-j-1);
			for(int j=0;j<b.length()-1;j++)n2[j]=b.charAt(b.length()-j-1);
			int cy=0;
			for(int j=0;j<size;j++){
				int s=n1[j]+n2[j]+cy;
				ans[j]=s%10;
				cy=s/10;
			}
			ans[size]=cy;
			for(int j=0;j<size;j++){
				
			}
		}
	}
}
