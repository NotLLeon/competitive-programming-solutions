import java.io.*;
import java.util.*;
public class year2018p6 {
	static ArrayList<Integer>[]adj;
	static int[]c;
	public static void main(String[] args) throws IOException {
		Reader r = new Reader();
		int n=r.nextInt(), Q=r.nextInt();
		adj=new ArrayList[n];
		c=new int[n];
		for(int i=0;i<n;i++){
			adj[i]=new ArrayList<Integer>();
			c[i]=r.nextInt();
		}
		for(int i=0;i<n-1;i++){
			int x=r.nextInt()-1, y=r.nextInt()-1;
			adj[x].add(y);adj[y].add(x);
		}
		for(int o=0;o<Q;o++){
			int x=r.nextInt()-1, y=r.nextInt()-1;
			Queue<Integer>q=new LinkedList<Integer>();
			int []prev=new int[n];
			q.add(x);
			prev[x]=-1;
			pnt:
			while(!q.isEmpty()){
				int cur=q.poll();
				for(int i:adj[cur]){
					if(i!=prev[cur]){
						prev[i]=cur;
						q.add(i);
						if(i==y)break pnt;
					}
				}
			}
			LinkedList<Integer>l=new LinkedList<Integer>();
			l.add(c[x]);
			int cur=y;
			while(cur!=x){
				l.add(c[cur]);
				cur=prev[cur];
			}
			Collections.sort(l);
			int p=l.poll(), min=Integer.MAX_VALUE;
			while(!l.isEmpty()){
				int pl=l.poll();
				min=Math.min(min, Math.abs(p-pl));
				p=pl;
			}
			System.out.println(min);
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
