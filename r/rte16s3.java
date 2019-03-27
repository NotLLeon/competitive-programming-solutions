import java.util.*;
import java.io.*;
public class rte16s3 {
	static class node implements Comparable<node>{
		int ind, w, prev;
		node(int a, int b, int c){
			ind=a;w=b;prev=c;
		}
		public int compareTo(node e){
			return this.w-e.w;
		}
	}
	public static void main(String[] args) throws IOException {
		Reader r=new Reader();
		int n=r.nextInt();
		ArrayList<node>[]adj=new ArrayList[n];
		int[]lvl=new int[n];
		int [][]LCA=new int[n][(int)(Math.ceil(Math.log(n)/Math.log(2)))+1];
		int[][]ans=new int[n][(int)(Math.ceil(Math.log(n)/Math.log(2)))+1];
		for(int i=0;i<n;i++){
			adj[i]=new ArrayList<node>();
			Arrays.fill(ans[i], -1);
		}
		for(int i=0;i<n-1;i++){
			int n1=r.nextInt(), n2=r.nextInt(), w=r.nextInt();
			adj[n1].add(new node(n2,w,-1));
			adj[n2].add(new node(n1,w,-1));
		}
		int q=r.nextInt();
		PriorityQueue<node>pq=new PriorityQueue<node>();
		boolean[]vis=new boolean[n];
		Queue<node>Q=new LinkedList<node>();
		vis[0]=true;
		Q.add(new node(0,0,-1));
		while(!Q.isEmpty()){
			node cur=Q.poll();
			for(node nxt:adj[cur.ind]){
				if(vis[nxt.ind])continue;
				vis[nxt.ind]=true;
				lvl[nxt.ind]=lvl[cur.ind]+1;
				ans[nxt.ind][0]=nxt.w;
				LCA[nxt.ind][0]=cur.ind;
				Q.add(nxt);
			}
		}
		for(int i=0;i<(int)(Math.ceil(Math.log(n)/Math.log(2)));i++){
			for(int j=0;j<n;j++){
				if(LCA[j][i]==-1)continue;
				LCA[j][i+1]=LCA[LCA[j][i]][i];
				if(LCA[j][i+1]!=-1){
					ans[j][i+1]=ans[LCA[j][i]][i]+ans[j][i];
				}
			}
		}
		for(int i=0;i<q;i++){
			int x=r.nextInt(), y=r.nextInt();
			long total=0;
			if(lvl[x]<lvl[y]){
				int temp=x;
				x=y;
				y=temp;
			}
			int diff=lvl[x]-lvl[y];
			for (int j=0; j<(int)(Math.ceil(Math.log(n)/Math.log(2)))+1; j++){
				if (((diff>>j)&1)!=0){
					total+=ans[x][j];
					x=LCA[x][j];
				}
			}
			int x1=x, y1=y;
			int lca=0;
			if(x==y)lca=x;
			else{
				for(int j=(int)(Math.ceil(Math.log(n)/Math.log(2)));j>=0;j--){
					if(LCA[x][j]!=LCA[y][j]){
						x=LCA[x][j];
						y=LCA[y][j];
					}
				}
				lca=LCA[x][0];
			}
			diff=lvl[x1]-lvl[lca];
			for (int j=0; j<(int)(Math.ceil(Math.log(n)/Math.log(2)))+1; j++){
				if (((diff>>j)&1)!=0){
					total+=ans[x1][j];
					total+=ans[y1][j];
					x1=LCA[x1][j];
					y1=LCA[y1][j];
				}
			}
			System.out.println(total);
		}
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