import java.io.*;
import java.util.*;
public class dmopc17c1p1 {
	//LOL WTF
static class pair{
	int r, c;
	pair(int a, int b){
		r=a;
		c=b;
	}
}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r=Integer.parseInt(st.nextToken()), c=Integer.parseInt(st.nextToken());
		LinkedList<pair>l=new LinkedList<pair>();
		for(int i=0;i<r;i++){
			String s=br.readLine();
			for(int j=0;j<c;j++){
				if(s.charAt(j)=='X'){
					l.add(new pair(i,j));
				}
			}
		}
		int[][]arr=new int[l.size()][2];
		int ind=0;
		while(!l.isEmpty()){
			pair p=l.poll();
			arr[ind][0]=p.r;arr[ind][1]=p.c;
			ind++;
		}
		int q=Integer.parseInt(br.readLine());
		for(int i=0;i<q;i++){
			boolean flag =false;
			st=new StringTokenizer(br.readLine());
			int r1=Integer.parseInt(st.nextToken())-1, c1=Integer.parseInt(st.nextToken())-1;
			for(int j=0;j<ind;j++){
				int t1=arr[j][0], t2=arr[j][1];
				if(t1==c1||t2==r1){
					System.out.println("Y");
					flag=true;
					break;
				}
			}
			if(!flag)System.out.println("N");
		}
	}
}
