import java.util.*;
import java.io.*;
public class globexcup18s2 {
	static class test implements Comparable<test>{
		int x,y;
		test(int a, int b){
			x=a;
			y=b;
		}
		public int compareTo(test e){
			return this.y-e.y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()), m=Integer.parseInt(st.nextToken()),k=Integer.parseInt(st.nextToken());
		test[]t=new test[n];
		int tot=0;
		for(int i=0;i<n;i++){
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			tot+=x;
			t[i]=new test(x,Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(t);
		int tgt=k*n;
		int ind=0, ans=0;
		while(tot<tgt){
			if(m-t[ind].x+tot<tgt){
				ans+=t[ind].y*(m-t[ind].x);
				tot+=m-t[ind].x;
				ind++;
			}else{
				ans+=t[ind].y*(tgt-tot);
				break;
			}
		}
		System.out.println(ans);
	}

}
