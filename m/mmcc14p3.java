import java.util.*;
public class mmcc14p3 {
	static int n,s;
	static LinkedList<Integer>[]adj;
	static LinkedList<Integer>leaves;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt(); s=sc.nextInt();
		adj=new LinkedList[n];
		for(int i=0;i<n;i++)adj[i]=new LinkedList<Integer>();
		for(int i=0;i<n-1;i++){
			int x=sc.nextInt()-1, y=sc.nextInt()-1;
			adj[x].add(y);adj[y].add(x);
		}
		leaves=new LinkedList<Integer>();
		for(int i=0;i<n;i++)if(adj[i].size()==1)leaves.add(i);
		
	}

}
