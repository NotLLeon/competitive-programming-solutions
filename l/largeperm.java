import java.util.*;
import java.io.*;
public class largeperm {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()), k=Integer.parseInt(st.nextToken());
		int[]ar=new int[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)ar[i]=Integer.parseInt(st.nextToken());
		for(int i=n;i>1&&k>0;i--){
			for(int j=n-i+1;j<n;j++){
				if(ar[j]==i){
					ar[j]=ar[n-i];
					ar[n-i]=i;
					k--;
					break;
				}
			}
		}
		for(int i=0;i<n;i++)System.out.print(ar[i]+" ");
	}

}
