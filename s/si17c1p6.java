import java.util.*;
import java.io.*;
public class si17c1p6 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int c=Integer.parseInt(st.nextToken()), t=Integer.parseInt(st.nextToken());
		TreeMap<Integer, Integer>tm=new TreeMap<Integer, Integer>();
		PriorityQueue<Integer>pq=new PriorityQueue<Integer>();
		for(int i=0;i<c;i++){
			int nx=Integer.parseInt(br.readLine());
			if(tm.containsKey(nx))tm.put(nx, tm.remove(nx)+1);
			else{
				tm.put(nx,(int) 1);
				pq.add(nx);
			}
		}
		int f=0, cur=0, nxt=0;
		while(t>0&&pq.size()>1){
			cur=pq.poll();
			nxt=pq.peek();
			f=tm.get(cur);
			if(f*(nxt-cur)>t){
				System.out.println(cur+t/f);
				return;
			}
			t-=f*(nxt-cur);
			tm.remove(cur);
			tm.put(nxt, tm.remove(nxt)+f);
		}
		int last=pq.poll();
		System.out.println(last+(t==0?0:t/tm.get(last)));
	}
}
