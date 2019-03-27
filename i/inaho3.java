import java.util.*;
import java.io.*;
public class inaho3 {
	static class edge implements Comparable<edge>{
		long dis;
		int ind;
		edge(long a, int b){
			dis=a;ind=b;
		}
		public int compareTo(edge e){
			if(this.dis<e.dis)return -1;
			else return 1;
		}
	}
	public static void main(String[] args) throws IOException {
		Reader r = new Reader();
		int n=r.nextInt(), total=1, start=0, end=0;
		int [] pma=new int[n], sz=new int[n], bound=new int[n];
		for(int i=0;i<n;i++){
			sz[i]=r.nextInt();
			total*=sz[i];
			bound[i]=sz[i];
		}
		if(n>=2){
			bound[0]=sz[1];
			bound[1]=sz[0];
		}
		if(n>0)pma[0]=1;
		for(int i=1;i<n;i++){
			pma[i]=pma[i-1]*sz[i];
			bound[i]*=bound[i-1];
		}
		long []d=new long[total];
		for(int i=0;i<total;i++){
			d[i]=r.nextLong();
			if(d[i]<d[end])end=i;
			if(d[i]>=d[start])start=i;
		}
		long[]dis=new long[total];
		boolean []vis=new boolean[total];
		dis[start]=d[start];
		vis[start]=true;
		PriorityQueue<edge>q=new PriorityQueue<edge>();
		q.add(new edge(d[start],start));
		while(!q.isEmpty()&&!vis[end]){
			edge cur=q.poll();
			for(int i=0;i<n;i++){
				if(sz[i]==1)continue;
				int mv=pma[i], bnd=bound[i];
				if((cur.ind+mv)/bnd==cur.ind/bnd&&!vis[cur.ind+mv]){
					vis[cur.ind+mv]=true;
					dis[cur.ind+mv]=cur.dis+d[cur.ind+mv];
					q.add(new edge(dis[cur.ind+mv], cur.ind+mv));
				}
				if(cur.ind-mv>=0&&(cur.ind-mv)/bnd==cur.ind/bnd&&!vis[cur.ind-mv]){
					vis[cur.ind-mv]=true;
					dis[cur.ind-mv]=cur.dis+d[cur.ind-mv];
					q.add(new edge(dis[cur.ind-mv], cur.ind-mv));
				}
			}
		}
		System.out.println(dis[end]);

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

