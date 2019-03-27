import java.util.*;
import java.io.*;
public class tle16c4p4 {
	static class pair{
		int node;
		long dis;
		pair(int a , long b){
			node=a;
			dis=b;
		}
	}
	static boolean[]vis;
	static long []dis;
	static Queue<pair>[]adj;
	static long[][] pth;
	static int n;
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
	public static void main(String[] args)throws IOException {
		Reader r = new Reader();
		n=r.nextInt(); 
		int m=r.nextInt(), q=r.nextInt();
		vis=new boolean[n];
		pth=new long[n][2];
		dis=new long[n];
		adj=new LinkedList[n];
		for(int i=0;i<n;i++){
			adj[i]=new LinkedList<pair>();
		}
		for(int i=0;i<m;i++){
			int n1=r.nextInt()-1, n2=r.nextInt()-1, w=r.nextInt();
			adj[n1].add(new pair(n2,w));
			adj[n2].add(new pair(n1,w));
		}
		long maxd=0, maxr=0, ex=0;
		for(int i=0;i<n;i++){
			if(vis[i])continue;
			int a=BFS(i).node;
			pair bfsb=BFS(a);
			long diam=bfsb.dis;
			if(q==1){
				maxd+=diam+1;
			}else{
				long radius=diam, sf=0;
				int ind=bfsb.node;
				while(!adj[i].isEmpty()){
					sf+=pth[ind][1];
					long max=Math.max(diam-sf, sf);
					if(max<radius)radius=max;
					else break;
					ind=(int) (pth[ind][0]-1);
				}
				if(radius>maxr){
					maxr=radius;
					ex=0;
				}
				else if(radius==maxr)ex=1;
			}
		}
		if(q==1)System.out.println(maxd-1);
		else System.out.println(maxr+ex);
	}

	static pair BFS(int node){
		Queue<Integer>q=new LinkedList<Integer>();	
		q.add(node);
		long max=0;
		int maxn=node;
		dis[node]=0;
		pth[node][0]=0;pth[node][1]=0;
		while(!q.isEmpty()){
			int cur=q.poll();
			for(int k=0;k<adj[cur].size();k++){
				pair i=adj[cur].poll();
				int nxt=i.node;
				long l=i.dis;
				if(nxt!=pth[cur][0]-1){
					vis[nxt]=true;
					q.add(nxt);
					dis[nxt]=dis[cur]+l;
					pth[nxt][0]=cur+1;
					pth[nxt][1]=l;
					if(dis[nxt]>max){
						max=dis[nxt];
						maxn=nxt;
					}
				}
				adj[cur].add(i);
			}
		}
		return new pair(maxn, max);
	}
}