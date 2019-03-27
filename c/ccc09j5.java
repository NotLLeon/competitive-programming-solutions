import java.util.*;
public class ccc09j5 {
	//BFS woot woot
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [][] adj=new int[51][51];
		adj[8][9]=1;adj[9][8]=1;adj[7][8]=1;adj[8][7]=1;
		adj[6][7]=1;adj[7][6]=1;adj[2][6]=1;adj[6][2]=1;
		adj[1][6]=1;adj[6][1]=1;adj[3][6]=1;adj[6][3]=1;
		adj[4][6]=1;adj[6][4]=1;adj[6][5]=1;adj[5][6]=1;
		adj[3][15]=1;adj[15][3]=1;adj[5][3]=1;adj[3][5]=1;
		adj[15][13]=1;adj[13][15]=1;adj[12][13]=1;adj[13][12]=1;
		adj[9][10]=1;adj[10][9]=1;adj[12][11]=1;adj[11][12]=1;
		adj[11][10]=1;adj[10][11]=1;adj[9][12]=1;adj[12][9]=1;
		adj[13][14]=1;adj[14][13]=1;adj[16][18]=1;adj[18][16]=1;
		adj[18][17]=1;adj[17][18]=1;adj[16][17]=1;adj[17][16]=1;
		adj[3][4]=1;adj[4][3]=1;adj[4][5]=1;adj[5][4]=1;
		
		while(true){
			String s=sc.next();
			if(s.equals("q")){
				break;
			}else if(s.equals("i")){
				int x=sc.nextInt();
				int y=sc.nextInt();
				adj[x][y]=1;
				adj[y][x]=1;
			}else if(s.equals("d")){
				int x=sc.nextInt();
				int y=sc.nextInt();
				adj[x][y]=0;
				adj[y][x]=0;
			}else if(s.equals("n")){
				int x=sc.nextInt();
				int cnt=0;
				for(int i=0;i<51;i++){
					if(adj[x][i]==1){
						cnt++;
					}
				}
				System.out.println(cnt);
			}else if(s.equals("f")){
				int x=sc.nextInt();
				getFriends(x,adj);
			}else if(s.equals("s")){
				int x=sc.nextInt();
				int y=sc.nextInt();
				getPath(x,y,adj);
			}
		}

	}
	public static void getPath(int x, int y, int[][]a){
		int n=0;
		boolean []b=new boolean[51];
		b[x]=true;
		boolean flag=false;
		Deque <Integer>q=new LinkedList<Integer>();
		q.add(x);
		int cnt=0;
		int v=q.peek();
		while(!q.isEmpty()){
			int cur = q.poll();
			if(cur==y){
				flag=true;
				System.out.println(n);
				break;
			}
			for(int i=0;i<51;i++){
				if(a[cur][i]==1&&b[i]!=true){
					b[i]=true;
					q.add(i);
				}
			}
			if(!q.contains(v)&&!q.isEmpty()){
				n++;
				v=q.peekLast();
			}
			
		}
		if(flag==false){
			System.out.println("Not connected");
		}

	}
	public static void getFriends(int a, int[][]b){
		int n=0;
		boolean flag=false;
		boolean []bb=new boolean[51];
		bb[a]=true;
		Deque <Integer>q=new LinkedList<Integer>();
		q.add(a);
		int v= q.peek();
		while(!q.isEmpty()){

			int cur = q.poll();
			for(int i=0;i<51;i++){
				if(b[cur][i]==1&&bb[i]!=true){
					bb[i]=true;
					q.add(i);
				}
			}
			if(!q.contains(v)&&!q.isEmpty()){
				n++;
				v=q.peekLast();
			}
			if(n==2){
				System.out.println(q.size());
				flag=true;
				break;
			}

		}
		if(flag==false){
			System.out.println(0);
		}
	}

}