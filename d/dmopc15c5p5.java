import java.util.*;
import java.io.*;
public class dmopc15c5p5 {
	public static class POC{
		POC parent;
		int key, pkey; 
		long div;
		POC( int k){
			key=k;
			div=1;
			pkey=-1;
			parent=null;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		POC [] arr=new POC[n];
		for(int i=0;i<n;i++){
			arr[i]=new POC(i);
		}
		int root=0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			int cnct=Integer.parseInt(st.nextToken());
			if(cnct==0){
				root=i;
			}else{
				arr[i].parent=arr[cnct-1];
				arr[i].pkey=cnct-1;
			}
		}
		long []divs=new long[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			int df=Integer.parseInt(st.nextToken()), j=df-1;
			long divf=arr[j].div;
			divs[j]=divf;
			while(arr[j].key!=root){
				j=arr[j].pkey;
				arr[j].div+=divf;
			}
		}
		for(int i=0;i<n;i++){
			System.out.print((divs[i]%1000000007)+" ");
		}
	}
}
