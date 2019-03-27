import java.util.*;
import java.io.*;
public class coci07c5p6 {
	static class Node{
		String val;
		int cnt;
		Node[]c;
		Node(String a){
			val=a;
			cnt=1;
			c=new Node[26];
		}
	}
	static void insert(String s, Node root){
		if(s.equals(""))return;
		int l=s.charAt(0)-97, ind=-1;
		if(root.c[l]==null){
			root.c[l]=new Node(s);
			return;
		}
		String cur=root.c[l].val;
		for(int i=0;i<Math.min(cur.length(),s.length());i++){
			if(cur.charAt(i)==s.charAt(i))ind=i+1;
			else break;
		}
		String pre=s.substring(0, ind);
		if(pre.equals(s)&&pre.equals(cur)){
			root.c[l].cnt++;
		}else if(pre.equals(cur)){
			root.c[l].cnt++;
			insert(s.substring(ind), root.c[l]);
		}else{
			Node swap=root.c[l];
			swap.val=cur.substring(ind);
			root.c[l]=new Node(cur.substring(0,ind));
			root.c[l].cnt=swap.cnt+1;
			root.c[l].c[swap.val.charAt(0)-97]=swap;
			insert(s.substring(ind), root.c[l]);
		}
	}
	static int find(String s, Node root){
		if(s.equals("")||root.c[s.charAt(0)-97]==null)return 0;
		Node cur=root.c[s.charAt(0)-97];
		int total=0;
		for(int i=0;i<Math.min(s.length(), cur.val.length());i++){
			if(s.charAt(i)==cur.val.charAt(i))total++;
			else return total*cur.cnt;
		}
		return total*cur.cnt+find(s.substring(total),cur);
	}
	static Node rt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		TreeMap<String, LinkedList<Integer>>tm=new TreeMap<String, LinkedList<Integer>>();
		String []a=new String[n];
		rt=new Node(null);
		for(int i=0;i<n;i++)a[i]=br.readLine();
		int q=Integer.parseInt(br.readLine());
		int []ans=new int[q];
		for(int i=0;i<q;i++){
			String s=br.readLine();
			if(!tm.containsKey(s)){
				LinkedList<Integer>l=new LinkedList<Integer>();
				l.add(i);
				tm.put(s, l);
			}else tm.get(s).add(i);
		}
		for(int i=0;i<n;i++){
			insert(a[i], rt);
			if(tm.containsKey(a[i])){
				int sna=i+1+find(a[i], rt);
				LinkedList<Integer>l=tm.remove(a[i]);
				while(!l.isEmpty())ans[l.poll()]=sna;
			}
		}
		while(!tm.isEmpty()){
			String s=tm.firstKey();
			int sna=n+find(s, rt);
			LinkedList<Integer>l=tm.remove(s);
			while(!l.isEmpty())ans[l.poll()]=sna;
		}
		for(int i=0;i<q;i++)System.out.println(ans[i]);
	}
}