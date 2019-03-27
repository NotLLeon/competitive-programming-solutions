import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class dmopc17c1p3 {
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
	public static void main(String[] args) throws IOException {
		Reader r =new Reader();
		int n=r.nextInt(), m=r.nextInt();
		LinkedList<Integer>[][]adj=new LinkedList[n][2];
		for(int i=0;i<n;i++){
			adj[i][0]=new LinkedList<Integer>();
			adj[i][1]=new LinkedList<Integer>();
		}
		for(int i=0;i<m;i++){
			int t=r.nextInt()-1, f=r.nextInt()-1, s=r.nextInt();
			adj[t][0].add(f);adj[t][1].add(s);
			adj[f][0].add(t);adj[f][1].add(s);
		}
		int[][]dis=new int[n][2];
		boolean[]vis=new boolean[n];
		Queue<Integer>q=new LinkedList<Integer>();
		q.add(0);dis[0][0]=0;dis[0][1]=0;
		vis[0]=true;
		while(!q.isEmpty()){
			int cur=q.poll();
			for(int i=0;i<adj[cur][0].size();i++){
				int node=adj[cur][0].get(i);
				if(!vis[node]||dis[cur][1]+adj[cur][1].get(i)<dis[node][1]||(dis[cur][1]+adj[cur][1].get(i)==dis[node][1]&&dis[cur][0]+1<dis[node][0])){
					q.add(node);
					vis[node]=true;
					dis[node][0]=dis[cur][0]+1;
					dis[node][1]=dis[cur][1]+adj[cur][1].get(i);
				}
			}
		}
		if(vis[n-1])System.out.println(dis[n-1][1]+" "+dis[n-1][0]);
		else System.out.println(-1);
	}
}
