import java.util.*;
import java.io.*;
public class year2017p1 {
	static class pair{
		int a,  b;
		pair(int a, int b){
			this.a=a;
			this.b=b;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine()), time=0;
		Deque<pair>q=new LinkedList<pair>();
		TreeMap<Integer, Integer>r=new TreeMap<Integer, Integer>();
		for(int i=0;i<n;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			char cmd=st.nextToken().charAt(0);
			int x=Integer.parseInt(st.nextToken());
			r.remove(x);
			if(cmd=='F'){
				q.addFirst(new pair(x,time));
				r.put(x,time++);
			}else if(cmd=='E'){
				q.addLast(new pair(x,time));
				r.put(x,time++);
			}else{
				r.put(x, -1);
			}
		}
		while(!q.isEmpty()){
			if(q.peek().b==r.get(q.peek().a)){
				System.out.println(q.poll().a);
			}else{
				q.poll();
			}
		}
		

	}
}
