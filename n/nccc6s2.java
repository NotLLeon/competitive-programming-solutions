import java.util.*;
import java.io.*;
public class nccc6s2 {

	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[][]ar=new int[n][n];
		for(int i=0;i<n;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++)ar[i][j]=Integer.parseInt(st.nextToken());
		}
		int cnt=0;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(ar[i][j]!=n*i+j+1)cnt++;
			}
			if(cnt!=0)break;
		}
		System.out.println(cnt);

	}

}
