import java.util.*;
import java.io.*;
public class coci17c2p2 {
	static class word implements Comparable<word>{
		String s;
		int f;
		word(String a){
			s=a;
			f=0;
		}
		public int compareTo(word e){
			if(this.f==e.f)return this.s.compareTo(e.s);
			return this.f-e.f;
		}
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k=Integer.parseInt(st.nextToken()), n=Integer.parseInt(st.nextToken());
		PriorityQueue<word>[]ar=new PriorityQueue[26];
		for(int i=0;i<26;i++)ar[i]=new PriorityQueue<word>();
		for(int i=0;i<k;i++){
			String ss=br.readLine();
			ar[ss.charAt(0)-'a'].add(new word(ss));
		}
		for(int i=0;i<n;i++){
			String ss=br.readLine();
			word ans=ar[ss.charAt(0)-'a'].poll();
			System.out.println(ans.s);
			ans.f++;
			ar[ss.charAt(0)-'a'].add(ans);
		}

	}

}
