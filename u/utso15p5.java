import java.util.*;
import java.io.*;
public class utso15p5 {
	static int [][]LCA, MAXA;
	static ArrayList<int[]>[]adj;
	static boolean [] used;
	static int []lvl;
	static int lg;
	static class node implements Comparable<node>{
		int ind, w, prev, eind;
		node(int a, int b, int c, int d){
			ind=a;w=b;prev=c;eind=d;
		}
		public int compareTo(node e){
			return this.w-e.w;
		}
	}
	static int findMax(int x, int y){
		if(lvl[x]<lvl[y]){
			int temp=x;
			x=y;
			y=temp;
		}
		//make level **fix***
		int max=0, diff=lvl[x]-lvl[y];
		for (int i=0; i<lg; i++){
			if (((diff>>i)&1)!=0){
				max=Math.max(max, MAXA[x][i]);
				x = LCA[x][i];
			}
		}
		int x1=x, y1=y;
		//find LCA
		int lca=0;
		if(x==y)lca=x;
		else{
			for(int i=lg-1;i>=0;i--){
				if(LCA[x][i]!=LCA[y][i]){
					x=LCA[x][i];
					y=LCA[y][i];
				}
			}
			lca=LCA[x][0];
			if(lca==-1)return -1;
		}
		//find max weight ***fix***
		diff=lvl[x1]-lvl[lca];
		for (int i=0; i<lg; i++){
			if (((diff>>i)&1)!=0){
				max=Math.max(max, MAXA[x1][i]);
				max=Math.max(max, MAXA[y1][i]);
				x1=LCA[x1][i];
				y1=LCA[y1][i];
			}
		}
		return max;
	}
	public static void main(String[] args) throws IOException {
		Reader r = new Reader();
		int n=r.nextInt(), m=r.nextInt(), sz=0;
		lg=(int)(Math.ceil(Math.log(n)/Math.log(2)))+1;
		adj=new ArrayList[n];
		LCA=new int[n][lg];MAXA=new int[n][lg];
		lvl=new int[n];used=new boolean[m];
		int [][]edges=new int[m][3];
		boolean []vis=new boolean[n];
		PriorityQueue<node>q=new PriorityQueue<node>();
		for(int i=0;i<n;i++){
			adj[i]=new ArrayList<int[]>();
			for(int j=0;j<lg;j++)LCA[i][j]=-1;
		}
		for(int i=0;i<m;i++){
			int n1=r.nextInt()-1, n2=r.nextInt()-1, w=r.nextInt();
			adj[n1].add(new int[]{n2, w, i});
			adj[n2].add(new int[]{n1, w, i});	
			edges[i][0]=n1; edges[i][1]=n2; edges[i][2]=w;
		}
		q.add(new node(0,0,-1,-1));
		int cnt=0;
		while(!q.isEmpty()){
			node cur=q.poll();
			if(vis[cur.ind])continue;
			cnt++;
			if(cur.prev!=-1){
				LCA[cur.ind][0]=cur.prev;
				lvl[cur.ind]=lvl[cur.prev]+1;
			}
			if(cur.eind!=-1)used[cur.eind]=true;
			MAXA[cur.ind][0]=cur.w;
			sz+=cur.w;
			vis[cur.ind]=true;
			for(int[]nxt:adj[cur.ind]){
				if(!vis[nxt[0]]&&!used[nxt[2]])
					q.add(new node(nxt[0], nxt[1], cur.ind, nxt[2]));
			}
		}
		if(cnt!=n){
			System.out.println(-1);
			return;
		}
		for(int i=0;i<lg-1;i++){
			for(int j=0;j<n;j++){
				if(LCA[j][i]==-1)continue;
				LCA[j][i+1]=LCA[LCA[j][i]][i];	
				if(LCA[j][i+1]!=-1)
					MAXA[j][i+1]=Math.max(MAXA[j][i],MAXA[LCA[j][i]][i]);
			}
		}
		int min=Integer.MAX_VALUE;
		for(int i=0;i<m;i++){
			if(used[i])continue;
			int mx=findMax(edges[i][0], edges[i][1]);
			if(mx==-1)continue;
			int l=sz+edges[i][2]-mx;
			if(l>sz&&l<min)min=l;
		}
		if(min==Integer.MAX_VALUE)System.out.println(-1);
		else System.out.println(min);
	}
	static class Reader
	{
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader()
		{
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public Reader(String file_name) throws IOException
		{
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException
		{
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1)
			{
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException
		{
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do
			{
				ret = ret * 10 + c - '0';
			}  while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		public long nextLong() throws IOException
		{
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			}
			while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nextDouble() throws IOException
		{
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();

			do {
				ret = ret * 10 + c - '0';
			}
			while ((c = read()) >= '0' && c <= '9');

			if (c == '.')
			{
				while ((c = read()) >= '0' && c <= '9')
				{
					ret += (c - '0') / (div *= 10);
				}
			}

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException
		{
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException
		{
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException
		{
			if (din == null)
				return;
			din.close();
		}
	}
}