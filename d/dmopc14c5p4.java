import java.util.*;
import java.io.*;
public class dmopc14c5p4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()), m=Integer.parseInt(st.nextToken());
		LinkedList<Integer>p1=new LinkedList<Integer>(), p2=new LinkedList<Integer>();
		long sz1=0, sz2=0;
		for(int i=0;i<n;i++){
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken()), p=Integer.parseInt(st.nextToken());
			if(p==1){
				p1.add(s);
				sz1+=s;
			}else {
				p2.add(s);
				sz2+=s;
			}
		}
		long cur=p2.size()*2;
		Collections.sort(p1);
		Collections.sort(p2);
		LinkedList<Integer>q1=(LinkedList<Integer>) p1.clone(), q2=(LinkedList<Integer>) p2.clone();
		long max=0;
		while(!p2.isEmpty()){
			if(sz2<=m){
				while(!p1.isEmpty()&&sz2+p1.peekFirst()<=m){
					sz2+=p1.pollFirst();
					cur++;
				}
				max=Math.max(max, cur);
			}
			cur-=2;
			sz2-=p2.pollLast();
		}
		cur=q1.size();
		while(!q1.isEmpty()){
			if(sz1<=m){
				while(!q2.isEmpty()&&sz1+q2.peekFirst()<=m){
					sz1+=q2.pollFirst();
					cur+=2;
				}
				max=Math.max(max, cur);
			}
			cur--;
			sz1-=q1.pollLast();
		}
		System.out.println(max);
		
	}

}