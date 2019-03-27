/*
ID: NotLeon
LANG: JAVA
TASK: backforth
 */
import java.util.*;
import java.io.*;
public class backforth {
	static int ans;
	static TreeSet<Integer>c;
	static LinkedList<Integer>a,b;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("backforth.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));
		a=new LinkedList<Integer>();
		b=new LinkedList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int j=0;j<10;j++)a.add(Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		for(int j=0;j<10;j++)b.add(Integer.parseInt(st.nextToken()));
		c=new TreeSet<Integer>();
		ans=0;
		solve(0,1000,1000,a,b);
		out.println(ans);
		out.close();
	}
	static void solve(int day,int c1, int c2, LinkedList<Integer>b1, LinkedList<Integer>b2){
		if(day==4){
			if(!c.contains(c1)){
				ans++;
				c.add(c1);
			}
			return;
		}
		if(day%2==0){
			for(int i:b1){
				if(c1-i>=0){
					LinkedList<Integer>temp1=new LinkedList<Integer>();
					for(int j:b2)temp1.add(j);
					temp1.add(i);
					LinkedList<Integer>temp2=new LinkedList<Integer>();
					boolean r=false;
					for(int j:b1){
						if(j!=i||r)temp2.add(j);
						else if(j==i)r=true;
					}
					solve(day+1,c1-i,c2+i,temp2,temp1);
				}
			}
		}else{
			for(int i:b2){
				if(c2-i>=0){
					LinkedList<Integer>temp1=new LinkedList<Integer>();
					for(int j:b1)temp1.add(j);
					temp1.add(i);
					LinkedList<Integer>temp2=new LinkedList<Integer>();
					boolean r=false;
					for(int j:b2){
						if(j!=i||r)temp2.add(j);
						else if(j==i)r=true;
					}
					solve(day+1,c1+i,c2-i,temp1,temp2);
				}
			}
		}
	}
	

}