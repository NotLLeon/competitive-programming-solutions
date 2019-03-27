import java.util.*;
import java.io.*;
public class cco13p2 {
	static int n;
	static class Node{
		int n, r;
		Node(int a, int b){
			n=a;
			r=b;
		}
	}
	static Node[]a;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());int m=Integer.parseInt(st.nextToken());
		int []lib=new int[(int)Math.pow(2, n)];
		a=new Node[(int) (Math.pow(2, n)*2-1)];
		for(int i=0;i<a.length;i++){
			a[i]=new Node(-1,0);
		}
		for(int i=0;i<Math.pow(2, n);i++){
			int val=Integer.parseInt(br.readLine());
			a[(int)Math.pow(2,n)-1+i].r=val;
			a[(int)Math.pow(2,n)-1+i].n=i;
			lib[i]=val;
		}
		build();
		for(int i=0;i<m;i++){
			st=new StringTokenizer(br.readLine());
			String s =st.nextToken();
			if(s.equals("R")){
				int l=Integer.parseInt(st.nextToken()),S=Integer.parseInt(st.nextToken());
				a[(int)Math.pow(2,n)+l-2].r=S;
				lib[l-1]=S;
				update((int)(Math.pow(2,n)-1+l));
			}else if(s.equals("W")){
				System.out.println(a[0].n+1);
			}else if(s.equals("S")){
				int ind=Integer.parseInt(st.nextToken())-1, val=lib[ind], cnt=0;
				int cur=(int)Math.pow(2, n)+ind;
				while(true){
					cur=cur/2;
					if(a[cur-1].r==val){
						cnt++;
					}
					if(cur==1){
						break;
					}
				}
				System.out.println(cnt);
			}
		}
	}
	public static void build(){
		for(int i=(int)Math.pow(2,n)-1;i>0;i--){
			if(a[i*2-1].r>a[i*2].r){
				a[i-1].n=a[i*2-1].n;
				a[i-1].r=a[i*2-1].r;
			}else{
				a[i-1].n=a[i*2].n;
				a[i-1].r=a[i*2].r;
			}
		}
	}
	public static void update(int n){
		n=n/2;
		while(n>0){
			if(a[n*2-1].r>a[n*2].r){
				a[n-1].n=a[n*2-1].n;
				a[n-1].r=a[n*2-1].r;
			}else{
				a[n-1].n=a[n*2].n;
				a[n-1].r=a[n*2].r;
			}
			n=n/2;
		}
	}
}