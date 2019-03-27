import java.util.*;
import java.io.*;
public class ncco4d1p3{
	static class Edge implements Comparable<Edge>{
		int x, dis;
		Edge(int a, int b){
			x=a;dis=b;
		}
		public int compareTo(Edge e){
			return this.dis-e.dis;
		}
	}
	public static void main(String[] args) throws IOException {
		Reader r = new Reader();
		int n=r.nextInt(), m=r.nextInt();
		ArrayList<Edge>[]adj=new ArrayList[n];
		for(int i=0;i<n;i++)adj[i]=new ArrayList<Edge>();
		for(int i=0;i<m;i++){
			int x=r.nextInt()-1, y=r.nextInt()-1, c=r.nextInt();
			adj[x].add(new Edge(y,c));
			adj[y].add(new Edge(x,c));
		}
		PriorityQueue<Edge>pq=new PriorityQueue<Edge>();
		int[]disa=new int[n], prev=new int[n], disb=new int[n];
		Arrays.fill(disa, -1);
		Arrays.fill(disb, -1);
		disa[n-1]=0;
		pq.add(new Edge(n-1,0));
		Arrays.fill(prev, -1);
		while(!pq.isEmpty()){
			Edge cur=pq.poll();
			for(Edge e:adj[cur.x]){
				if(disa[e.x]==-1||disa[cur.x]+e.dis<disa[e.x]){
					disa[e.x]=disa[cur.x]+e.dis;
					prev[e.x]=cur.x;
					pq.add(new Edge(e.x,disa[e.x]));
				}
			}
		}
		disb[0]=0;
		pq.add(new Edge(0,0));
		while(!pq.isEmpty()){
			Edge cur=pq.poll();
			for(Edge e:adj[cur.x]){
				if(disb[e.x]==-1||disb[cur.x]+e.dis<disb[e.x]){
					disb[e.x]=disb[cur.x]+e.dis;
					pq.add(new Edge(e.x,disb[e.x]));
				}
			}
		}
		int cv=0, min=Integer.MAX_VALUE, cr=0;
		do{
			for(Edge e:adj[cv]){
				cr=disa[cv]+e.dis+disb[e.x];
				if(cr>disb[n-1]&&cr<min)min=cr;
			}
			cv=prev[cv];
		}while(cv!=-1);
		System.out.println(min);
		
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