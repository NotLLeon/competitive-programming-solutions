import java.util.*;
public class ccc06j4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer>[] adj=new LinkedList[8];
		for(int i=0;i<adj.length;i++){
			adj[i]=new LinkedList<Integer>();
		}
		adj[1].add(7);adj[1].add(4);adj[2].add(1);adj[3].add(4);adj[3].add(5);

		int[]d=new int[8];
		while(true){
			int x=sc.nextInt(), y=sc.nextInt();
			if(x==0&&y==0)break;
			adj[x].add(y);
		}
		for(int i=0;i<adj.length;i++){
			for(int j=0;j<adj[i].size();j++){
				d[adj[i].get(j)]++;
			}
		}
		LinkedList <Integer>q=new LinkedList<Integer>();
		LinkedList<Integer>ans=new LinkedList<Integer>();
		for(int i=1;i<8;i++){
			if(d[i]==0){
				q.add(i);
			}
		}
		while(!q.isEmpty()){
			int cur=q.poll();
			ans.add(cur);
			for(int i:adj[cur]){
				d[i]--;
				if(d[i]==0){
					q.add(i);
					Collections.sort(q);
				}
			}
		}
		if(ans.size()==7){
			for(int i:ans){
				System.out.print(i+" ");
			}
		}else{
			System.out.println("Cannot complete these tasks. Going to bed.");
		}
	}

}