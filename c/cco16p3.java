import java.util.*;
import java.io.*;
public class cco16p3 {
	static int n, m,par[];
	static LinkedList<Integer>[] adj;
	static boolean[]vis;
	public static void main(String[] args) throws IOException {
		Reader r = new Reader();
		int s=r.nextInt(),t=r.nextInt();
		pnt:
			for(int tc=0;tc<t;tc++){
				n=r.nextInt(); m=r.nextInt();
				adj=new LinkedList[n];
				for(int i=0;i<n;i++)adj[i]=new LinkedList<Integer>();
				for(int i=0;i<m;i++){
					int x=r.nextInt()-1, y=r.nextInt()-1;
					adj[x].add(y);adj[y].add(x);
				}
				boolean[] v=new boolean[n];
				par=new int[n];
				for(int i=0;i<n;i++){
					Arrays.fill(v, false);
					for(int j:adj[i]){
						if(v[j]){
							System.out.println("NO");
							continue pnt;
						}else v[j]=true;
					}
				}

				vis=new boolean[n];	
				if(s==1){// 4 vertex cycle with 1 edge connecting 2 non-adj vertices

				}else if(s==2){// 3 vertex cycle
					System.out.println(maxCycle()>=3?"YES":"NO");
				}else if(s==3){// 4 vertex cycle
					System.out.println(maxCycle()>=4?"YES":"NO");
				}else if(s==4){// basic tree with 3 leaf vertices
					for(int i=0;i<n;i++){
						if(adj[i].size()>=3){
							System.out.println("YES");
							continue pnt;
						}
					}
					System.out.println("NO");
				}else{// 3 cycle node with 2 leaf vertices

				}
			}
	}
	static int maxCycle(){
		Queue<Integer>q=new LinkedList<Integer>();
		int []dis=new int[n];
		int [][]sparse=new int[n][(int)(Math.ceil(Math.log(n)/Math.log(2)))+1];
		for(int i=0;i<n;i++)Arrays.fill(sparse[i], -1);
		vis[0]=true;
		q.add(0);
		while(!q.isEmpty()){
			int cur=q.poll();
			for(int i:adj[cur]){
				if(!vis[i]){
					q.add(i);
					vis[i]=true;
					sparse[i][0]=cur;
					dis[i]=dis[cur]+1;
				}
			}
		}
		for(int i=0;i<sparse[0].length;i++){
			for(int j=0;j<n;j++){
				if(sparse[j][i]!=-1)sparse[j][i+1]=sparse[sparse[j][i]][i];
			}
		}	
		for(int i=0;i<n;i++)System.out.println(Arrays.toString(sparse[i]));
		vis=new boolean[n];
		int max=Integer.MIN_VALUE;
		q.add(0);
		vis[0]=true;
		while(!q.isEmpty()){
			int cur=q.poll();
			for(int i:adj[cur]){
				if(!vis[i]){
					q.add(i);
					vis[i]=true;
				}else if(sparse[cur][0]!=i){
					int size=0, x=cur, y=i, x1=x, y1=y,LCA=0, a=0;
					if(dis[x]<dis[y]){
						int temp=x;
						x=y;
						y=temp;
					}
					int diff=dis[x]-dis[y];
					for (int j=0; j<sparse[0].length; j++){
						if (((diff>>j)&1)!=0){
							a=(int) Math.pow(2, j);
							x=sparse[x][j];
						}
					}
					size+=a;a=0;
					if(x==y)LCA=x;
					else{
						for(int j=sparse[0].length-1;j>=0;j--){
							if(sparse[x][j]!=sparse[y][j]){
								x=sparse[x][j];
								y=sparse[y][j];
							}
						}
						LCA=sparse[x][0];
					}
					diff=dis[x1]-dis[LCA];
					for (int j=0; j<sparse[0].length; j++){
						if (((diff>>j)&1)!=0){
							a=(int) (2*Math.pow(2, j));
							x1=sparse[x1][j];
							y1=sparse[y1][j];
						}
					}
					size+=a;a=0;
					max=Math.max(max, size);
				}
			}
		}
		System.out.println(max+1);
		return max+1;
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