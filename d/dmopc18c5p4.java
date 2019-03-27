import java.util.*;
import java.io.*;
public class dmopc18c5p4 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[]a=new int[n], b=new int[n];
		String s=br.readLine();
		for(int i=0;i<n;i++)if(s.charAt(i)=='F')a[i]=1;
		s=br.readLine();
		for(int i=0;i<n;i++)if(s.charAt(i)=='F')b[i]=1;
		boolean w1=false, w2=false;
		for(int i=1;i<n;i++){
			if(a[i]==a[i-1])w1=true;
			if(b[i]==b[i-1])w2=true;
		}
		if(!w1||!w2){
			System.out.println("NO");
			return;
		}
		int cnt1=0, cnt2=0;
		for(int i=0;i<n;i++){
			cnt1+=a[i];
			cnt2+=b[i];
		}
		if((cnt1%2)!=(cnt2%2)){
			System.out.println("NO");
			return;
		}
		System.out.println("YES");
	}

}
