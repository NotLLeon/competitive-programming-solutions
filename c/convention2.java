/*
ID: NotLeon
LANG: JAVA
TASK: convention2
*/
import java.util.*;
import java.io.*;
public class convention2 {
	static class cow implements Comparable<cow>{
		int a, t,s;
		cow(int b, int c, int d){
			a=b;
			t=c;
			s=d;
		}
		public int compareTo(cow e){
			return this.a-e.a;
		}
	}
	static class cow1 implements Comparable<cow1>{
		int a, t, s;
		cow1(int b, int c, int d){
			a=b;
			t=c;
			s=d;
		}
		public int compareTo(cow1 e){
			return this.s-e.s;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("convention2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("convention2.out")));
		int n=Integer.parseInt(br.readLine());
		cow[]cs=new cow[n];
		StringTokenizer st;
		for(int i=0;i<n;i++){
			st=new StringTokenizer(br.readLine());
			cs[i]=new cow(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),i);
		}
		Arrays.sort(cs);
		int cur=cs[0].a, ind=0, max=0;
		PriorityQueue<cow1>pq=new PriorityQueue<cow1>();
		pq.add(new cow1(cs[ind].a, cs[ind].t,cs[ind].s));
		ind++;
		while(!pq.isEmpty()||ind<n){
			while(ind<n&&cs[ind].a<=cur){
				pq.add(new cow1(cs[ind].a, cs[ind].t,cs[ind].s));
				ind++;
			}
			if(pq.isEmpty()&&ind<n){
				pq.add(new cow1(cs[ind].a, cs[ind].t,cs[ind].s));
				cur=cs[ind].a;
				ind++;
			}
			
			cow1 cc=pq.poll();
			max=Math.max(cur-cc.a, max);
			cur+=cc.t;
		}
		out.println(max);
		out.close();
		
	}

}