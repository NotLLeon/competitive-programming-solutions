import java.util.*;
import java.io.*;
public class dmopc17c2p3 {
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
		Reader r = new Reader();
		int n=r.nextInt(), R=r.nextInt();
		boolean []d=new boolean[n];
		ArrayList<Integer>[]adj=new ArrayList[n];
		for(int i=0;i<n;i++)adj[i]=new ArrayList<Integer>();
		for(int i=0;i<n-1;i++){
			int n1=r.nextInt()-1, n2=r.nextInt()-1;
			adj[n1].add(n2);adj[n2].add(n1);
		}
		for(int i=0;i<R;i++){
			d[r.nextInt()-1]=true;
		}
		int x=r.nextInt()-1, y=r.nextInt()-1, min=Integer.MAX_VALUE;
		boolean[]vis=new boolean[n];
		Queue<Integer>q=new LinkedList<Integer>();
		vis[x]=true;q.add(x);
		int []dis=new int[n], prev=new int[n];
		while(!vis[y]){
			int cur=q.poll();
			for(int i:adj[cur]){
				if(!vis[i]){
					prev[i]=cur;
					vis[i]=true;
					q.add(i);
				}
			}
		}
		boolean []path=new boolean[n];
		int ind=y;
		path[y]=true;
		while(ind!=x){
			ind=prev[ind];
			path[ind]=true;
		}
		q=new LinkedList<Integer>();
		boolean[] vis1=new boolean[n];
		vis1[x]=true;q.add(x);
		while(!q.isEmpty()){
			int cur=q.poll();
			if(d[cur]&&dis[cur]<min)min=dis[cur];
			for(int i:adj[cur]){
				if(!vis1[i]){
					if(path[i])dis[i]=0;
					else dis[i]=dis[cur]+1;
					vis1[i]=true;
					q.add(i);
				}
			}
		}
		System.out.println(min);
	}
}
