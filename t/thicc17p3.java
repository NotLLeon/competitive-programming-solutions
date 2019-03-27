import java.util.*;
import java.io.*;
public class thicc17p3 {
	static class Query implements Comparable<Query>{
		int cq, x,y, ind;
		Query(int a, int b, int c, int i){
			cq=a;
			x=b;
			y=c;
			ind=i;
		}
		public int compareTo(Query e) {
			return this.y - e.y;
		}
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int []arr=new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int q=Integer.parseInt(br.readLine());
		int k=0;
		LinkedList<Query>l=new LinkedList<Query>();
		Query[]qs=new Query[q];
		for(int i=0;i<q;i++){
			st=new StringTokenizer(br.readLine());
			String s=st.nextToken();
			int x=Integer.parseInt(st.nextToken()), y=Integer.parseInt(st.nextToken());
			if(s.equals("C")){
				qs[i]=new Query(0,x,y, -1);
			}else{
				qs[i]=new Query(1,-1,-1, k);
				l.add(new Query(1,x,y, k));
				k++;
			}
		}
		int[]ans=new int[k];
		Collections.sort(l);
		Query cur=null;
		if(!l.isEmpty()){
			cur=l.poll();
		}
		int day=0;
		Query c=null;
		for(int i=0;i<q+1;i++){
			if(i<q){
				c=qs[i];
				if(c.cq==1)continue;
			}
			if(cur.y==day){
				ans[cur.ind]=arr[cur.x-1];
				if(!l.isEmpty()){
					cur=l.poll();
					i--;
					continue;
				}
			}
			if(i<q){
				arr[c.x-1]=c.y;
				day++;
			}
		}
		for(int i=0;i<k;i++){
			System.out.println(ans[i]);
		}
	}
}