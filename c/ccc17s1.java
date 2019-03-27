import java.util.*;
import java.io.*;
public class ccc17s1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[]s1=new int[n], s2=new int[n];
		int m=0,S1=0, S2=0;
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			s1[i]=Integer.parseInt(st.nextToken());
		}
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			s2[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<n;i++){
			S1+=s1[i];S2+=s2[i];
			if(S1==S2){
				m=i+1;
			}
		}
		System.out.println(m);

	}

}
