import java.util.*;
import java.io.*;
public class vmss7wc15c2p3 {
	static class node{
		long h;
		int cnt, hi;
		node(long a, int b){
			h=a;
			cnt=b;
			hi=0;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		Stack<node>s=new Stack<node>();
		long cnt=0;
		s.add(new node(Long.parseLong(br.readLine()), 0));
		for(int i=1;i<N;i++){
			node n=new node(Long.parseLong(br.readLine()), 0);
			while(true){
				if(n.h>s.peek().h){
					n.cnt++;
					cnt+=s.pop().cnt;
				}else if(n.h<s.peek().h){
					n.cnt++;
					n.hi++;
					s.add(n);
					break;
				}else{
					n.hi+=s.peek().hi+1;
					n.cnt+=s.peek().hi+1;
					s.add(n);
					break;
				}
				if(s.isEmpty()){
					s.add(n);
					break;
				}
			}
		}
		while(!s.isEmpty()){
			cnt+=s.pop().cnt;
		}
		System.out.println(cnt);

	}

}
