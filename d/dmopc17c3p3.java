import java.util.*;
public class dmopc17c3p3 {
	static boolean[]vis;
	static int n;
	static int[]p;
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		p=new int[n];
		for(int i=0;i<n;i++)p[i]=sc.nextInt();
		LinkedList<Integer>[]ans=solve(0, 0, 0);
		Collections.sort(ans[0]);
		while(!ans[0].isEmpty())System.out.print((ans[0].poll()+1)+" ");
		System.out.println();
		Collections.sort(ans[1]);
		while(!ans[1].isEmpty())System.out.print((ans[1].poll()+1)+" ");
	}
	public static LinkedList<Integer>[] solve(int ind, int t1, int t2){
		if(ind==n){
			LinkedList<Integer>[]l=new LinkedList[3];
			l[0]=new LinkedList<Integer>();
			l[1]=new LinkedList<Integer>();
			l[2]=new LinkedList<Integer>();
			l[2].add(Math.abs(t1-t2));
			return l;
		}
		LinkedList<Integer>[]p1=solve(ind+1, t1, t2+p[ind]);
		LinkedList<Integer>[]p2=solve(ind+1, t1+p[ind], t2);
		LinkedList<Integer>[]p3=solve(ind+1,t1, t2);
//		System.out.println(p1[2].peek()+" "+p2[2].peek()+" "+p3[2].peek());
		if(!(ind==n-1&&(p3[0].isEmpty()&&p3[1].isEmpty()))&&p3[2].peek()<=p2[2].peek()&&p3[2].peek()<=p1[2].peek()){
			return p3;
		}else if(p1[2].peek()<p2[2].peek()){
			p1[1].add(ind);
			return p1;
		}else{
			p2[0].add(ind);
			return p2;
		}
	}
}